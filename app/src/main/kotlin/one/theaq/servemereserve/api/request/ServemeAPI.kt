package one.theaq.servemereserve.api.request

import one.theaq.servemereserve.api.data.ServemeRegion
import java.net.URL

class ServemeAPI(
    val region: ServemeRegion,
    val apiKey: String
) {

    fun makeRequest(path: String, body: String): URL {
        val uri = region.uri.resolve(path)

        return uri.toURL()
    }
}