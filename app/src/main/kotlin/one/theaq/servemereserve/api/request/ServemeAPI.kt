package one.theaq.servemereserve.api.request

import net.dv8tion.jda.api.requests.Method
import one.theaq.servemereserve.api.data.ServemeRegion
import one.theaq.servemereserve.api.data.reservation.ServemeReservationsRequest
import tools.jackson.core.StreamReadFeature
import tools.jackson.databind.DeserializationFeature
import tools.jackson.module.kotlin.jsonMapper
import tools.jackson.module.kotlin.kotlinModule
import tools.jackson.module.kotlin.readValue
import java.net.http.HttpClient
import java.net.http.HttpClient.Redirect
import java.net.http.HttpClient.Version
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse
import java.util.*
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

class ServemeAPI(
    val region: ServemeRegion,
    val apiKey: String
) {
    val httpClient: HttpClient = HttpClient.newBuilder()
        .version(Version.HTTP_2)
        .followRedirects(Redirect.ALWAYS)
        .build()

    inline fun <reified T: Any> requestGET(path: String, classType: KClass<T>): T {
        return deserialize(path, Method.GET, Optional.empty(), Optional.empty(), classType)
    }

    inline fun <reified T : Any> deserialize(path: String, requestType: Method, header: Optional<Array<String>>, body: Optional<HttpRequest.BodyPublisher>, classType: KClass<T>): T {
        val response = makeRequest(path, Method.GET, Optional.empty(), Optional.empty())
        val objectMapper = jsonMapper {
            addModule(kotlinModule())

            configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
            configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION, true) // TODO: debug line

        }

        return objectMapper.readValue(response)
    }

    fun makeRequest(path: String, requestType: Method, header: Optional<Array<String>>, body: Optional<HttpRequest.BodyPublisher>): String {
        val uri = region.uri.resolve("api/$path")

        val requestBuilder = HttpRequest.newBuilder()
            .uri(uri)
            .timeout(10.seconds.toJavaDuration())
            .header("accept", "application/json; charset=utf-8")
            .header("Content-Type", "application/json; charset=utf-8")
            .header("Authorization", "Bearer $apiKey")

        header.ifPresent { array -> requestBuilder.headers(*array) }

        val requestBody = body.orElse(BodyPublishers.noBody())
        when (requestType) {
            Method.HEAD -> requestBuilder.HEAD()
            Method.GET -> requestBuilder.GET()
            Method.DELETE -> requestBuilder.DELETE()
            Method.OPTIONS -> requestBuilder.method("OPTIONS", BodyPublishers.noBody())

            Method.PUT -> requestBuilder.PUT(requestBody)
            Method.POST -> requestBuilder.POST(requestBody)
            Method.PATCH -> requestBuilder.method("PATCH", requestBody)
        }


        val response = httpClient.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString())
        println("${response.statusCode()} ${response.body()}")

        return response.body()
    }
}