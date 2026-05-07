package one.theaq.servemereserve.api.data.reservation

import com.fasterxml.jackson.annotation.JsonProperty
import one.theaq.servemereserve.api.data.deserializer.KTDurationDeserializer
import one.theaq.servemereserve.api.data.server.ServemeServer
import tools.jackson.databind.annotation.JsonDeserialize
import java.net.URI
import java.time.LocalDateTime
import java.util.Optional
import kotlin.time.Duration

// TODO: make all nulls become -1 or empty strings
//      should be the case for all data objects
data class ServemeReservation(
    val id: Int, // id
    val status: ReservationStatus, // status
    @field:JsonProperty("starts_at")
    val startsAt: LocalDateTime, // starts_at
    @field:JsonProperty("ends_at")
    val endsAt: LocalDateTime, // ends_at
    @field:JsonProperty("server_id")
    val serverId: Int, //server_id nullable
    val password: String, // password nullable
    @field:JsonProperty("rcon")
    val rconPassword: String, // rcon nullable
    @field:JsonProperty("first_map")
    val firstMap: String, // first_map nullable
    @field:JsonProperty("tv_password")
    val stvPassword: String, // tv_password
    @field:JsonProperty("tv_relaypassword")
    val stvRelayPassword: String, // tv_relaypassword
    @field:JsonProperty("tv_port")
    val stvPort: Int, // tv_port nullable
    @field:JsonProperty("server_config_id")
    val configId: Int, // server_config_id nullable
    @field:JsonProperty("whitelist_id")
    val whitelistId: Int, // whitelist_id nullable
    @field:JsonProperty("custom_whitelist_id")
    val customWhitelistId: Int, // custom_whitelist_id nullable
    @field:JsonProperty("auto_end")
    val autoEnd: Boolean, // auto_end
    @field:JsonProperty("enable_plugins")
    val enablePlugins: Boolean, // enable_plugins
    @field:JsonProperty("enable_demos_tf")
    val enableDemosTF: Boolean, // enable_demos_tf
    @field:JsonProperty("sdr_ip")
    val sdrIP: URI, // sdr_ip
    @field:JsonProperty("sdr_port")
    val sdrPort: Int, // sdr_port
    @field:JsonProperty("sdr_tv_port")
    val sdrTVPort: Int, // sdr_tv_port
    @field:JsonProperty("sdr_final")
    val sdrFinal: Boolean, // sdr_final
    @field:JsonProperty("disable_democheck")
    val disableDemocheck: Boolean, // disable_democheck
    val errors: Optional<Map<String, String>>, // errors { "error_value": { "error": "error_description" } }
    @field:JsonProperty("democheck_mode")
    val democheckMode: ReservationDemomode, // democheck_mode
    @field:JsonProperty("last_number_of_players")
    val lastNumberOfPlayers: Int, // last_number_of_players
    @field:JsonProperty("inactive_minute_counter")
    @field:JsonDeserialize(using = KTDurationDeserializer::class)
    val inactiveMinuteCounter: Duration, // inactive_minute_counter
    @field:JsonProperty("logsecret")
    val logSecret: String, // logsecret
    @field:JsonProperty("start_instantly")
    val startInstantly: Boolean, // start_instantly
    @field:JsonProperty("end_instantly")
    val endInstantly: Boolean, // end_instantly
    val provisioned: Boolean, // provisioned
    val ended: Boolean, // ended
    @field:JsonProperty("steam_uid")
    val steamUID: String, // steam_uid
    val server: ServemeServer, // server
    @field:JsonProperty("log_uploads")
    val logUploads: List<String>, // log_uploads // TODO: figure out the right data type
    @field:JsonProperty("zipfile_url")
    val zipfileURL: URI, // zipfile_url
)