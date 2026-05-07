package one.theaq.servemereserve.api.data

import java.net.URI
import java.net.URL
import java.net.URLStreamHandler

enum class ServemeRegion(val uri: URI) {
    EU(URI.create("https://serveme.tf")),
    NA(URI.create("https://na.serveme.tf")),
    AU(URI.create("https://au.serveme.tf")),
    SEA(URI.create("https://sea.serveme.tf"));

    fun getURL(streamHandler: URLStreamHandler): URL {
        return URL.of(uri, streamHandler)
    }
}