package one.theaq.servemereserve.api.request

import net.dv8tion.jda.api.requests.Method
import one.theaq.servemereserve.api.data.ServemeRegion
import tools.jackson.databind.ObjectMapper
import java.net.http.HttpClient
import java.net.http.HttpClient.Redirect
import java.net.http.HttpClient.Version
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse
import java.util.*
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

    fun <T: Any> requestGET(path: String, javaClass: Class<T>): T {
        val response = makeRequest(path, Method.GET, Optional.empty())
        val objectMapper = ObjectMapper()

        return objectMapper.readValue(response, javaClass)
    }

    fun makeRequest(path: String, requestType: Method, body: Optional<HttpRequest.BodyPublisher>): String {
        val uri = region.uri.resolve("api/$path")

        val requestBuilder = HttpRequest.newBuilder()
            .uri(uri)
            .timeout(10.seconds.toJavaDuration())
            .header("accept", "application/json; charset=utf-8")
            .header("Content-Type", "application/json; charset=utf-8")
            .header("Authorization", "Bearer $apiKey")

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