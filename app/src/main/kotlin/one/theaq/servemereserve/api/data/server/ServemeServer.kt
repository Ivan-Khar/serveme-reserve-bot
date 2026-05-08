package one.theaq.servemereserve.api.data.server

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Optional

data class ServemeServer(
    val id: Int, // id
    val name: String, // name
    val flag: String, // flag
    val ip: String, // ip
    val port: Int, // port
    @field:JsonProperty("ip_and_port")
    val ipAndPort: Optional<String>, // ip_and_port
    @field:JsonProperty("resolved_ip")
    val resolvedIP: Optional<String>, // resolved_ip
    val sdr: Boolean, // sdr
    val latitude: String, // latitude
    val longitude: String // longitude
)