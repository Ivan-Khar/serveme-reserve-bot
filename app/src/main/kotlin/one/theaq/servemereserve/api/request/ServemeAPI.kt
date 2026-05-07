package one.theaq.servemereserve.api.request

import net.dv8tion.jda.api.requests.Method
import one.theaq.servemereserve.api.data.ServemeRegion
import java.net.http.HttpClient
import java.net.http.HttpClient.Redirect
import java.net.http.HttpClient.Version
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse
import java.util.Optional
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

    fun makeRequest(path: String, requestType: Method, body: Optional<HttpRequest.BodyPublisher>): HttpResponse<*> {
        val uri = region.uri.resolve(path)
        val requestBuilder = HttpRequest.newBuilder()
            .uri(uri)
            .timeout(10.seconds.toJavaDuration())
            .setHeader("Content-Type", "application/json")
            .setHeader("Accept", "application/json")
            .setHeader("Authorization", "Bearer $apiKey")

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

        return httpClient.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString())
    }
}