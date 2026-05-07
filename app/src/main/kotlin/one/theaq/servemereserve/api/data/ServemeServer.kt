package one.theaq.servemereserve.api.data

import java.net.URL
import java.util.Optional

data class ServemeServer(
    val id: Int, // id
    val name: String, // name
    val flag: String, // flag
    val ip: URL, // ip
    val port: Int, // port
    val ipAndPort: URL, // ip_and_port
    val resolvedIP: Optional<URL>, // resolved_ip
    val sdr: Boolean, // sdr
    val latitude: String, // latitude
    val longitude: String // longitude
) {}
