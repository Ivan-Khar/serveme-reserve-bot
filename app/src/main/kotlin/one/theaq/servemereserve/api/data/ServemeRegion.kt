package one.theaq.servemereserve.api.data

import java.net.URI

enum class ServemeRegion(val uri: URI) {
    EU(URI.create("https://serveme.tf")),
    NA(URI.create("https://na.serveme.tf")),
    AU(URI.create("https://au.serveme.tf")),
    SEA(URI.create("https://sea.serveme.tf"));

    fun apiPath(path: String): URI {
        return uri.resolve("/api/$path")
    }
}