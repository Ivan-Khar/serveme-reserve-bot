package one.theaq.servemereserve.api.data

import java.net.URI
import java.net.URL

enum class ServemeRegion(val uri: URI) {
    EU(URI.create("https://serveme.tf")),
    NA(URI.create("https://na.serveme.tf")),
    AU(URI.create("https://au.serveme.tf")),
    SEA(URI.create("https://sea.serveme.tf"));

    val url: URL
        get() = uri.toURL()
}