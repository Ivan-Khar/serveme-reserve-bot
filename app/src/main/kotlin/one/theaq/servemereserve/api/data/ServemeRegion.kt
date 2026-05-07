package one.theaq.servemereserve.api.data

import java.net.URI
import java.net.URL

enum class ServemeRegion(val uri: URI) {
    EU(URI.create("https://serveme.tf/api")),
    NA(URI.create("https://na.serveme.tf/api")),
    AU(URI.create("https://au.serveme.tf/api")),
    SEA(URI.create("https://sea.serveme.tf/api"));

    val url: URL
        get() = uri.toURL()
}