package one.theaq.servemereserve.api.data.reservation

import com.fasterxml.jackson.annotation.JsonProperty
import one.theaq.servemereserve.api.data.deserializer.KTDurationDeserializer
import one.theaq.servemereserve.api.data.server.ServemeServer
import tools.jackson.databind.annotation.JsonDeserialize
import java.util.Date
import java.util.Optional
import kotlin.time.Duration

// TODO: make all nulls become -1 or empty strings
//      should be the case for all data objects
data class ServemeReservation(
    @field:JsonProperty("id")
    val id: Int,
    @field:JsonProperty("status")
    val status: ReservationStatus,
    @field:JsonProperty("starts_at")
    val startsAt: Date,
    @field:JsonProperty("ends_at")
    val endsAt: Date,
    @field:JsonProperty("server_id")
    val serverId: Optional<Int>,
    @field:JsonProperty("password")
    val password: Optional<String>,
    @field:JsonProperty("rcon")
    val rconPassword: Optional<String>,
    @field:JsonProperty("first_map")
    val firstMap: Optional<String>,
    @field:JsonProperty("tv_password")
    val stvPassword: String,
    @field:JsonProperty("tv_relaypassword")
    val stvRelayPassword: String,
    @field:JsonProperty("tv_port")
    val stvPort: Optional<Int>,
    @field:JsonProperty("server_config_id")
    val configId: Optional<Int>,
    @field:JsonProperty("whitelist_id")
    val whitelistId: Optional<Int>,
    @field:JsonProperty("custom_whitelist_id")
    val customWhitelistId: Optional<String>,
    @field:JsonProperty("auto_end")
    val autoEnd: Boolean,
    @field:JsonProperty("enable_plugins")
    val enablePlugins: Boolean,
    @field:JsonProperty("enable_demos_tf")
    val enableDemosTF: Boolean,
    @field:JsonProperty("sdr_ip")
    val sdrIP: Optional<String>,
    @field:JsonProperty("sdr_port")
    val sdrPort: Optional<Int>,
    @field:JsonProperty("sdr_tv_port")
    val sdrTVPort: Optional<Int>,
    @field:JsonProperty("sdr_final")
    val sdrFinal: Boolean,
    @field:JsonProperty("disable_democheck")
    val disableDemocheck: Boolean,
    @field:JsonProperty("democheck_mode")
    val democheckMode: ReservationDemomode,
    @field:JsonProperty("errors")
    val errors: Optional<Map<String, String>>, // errors { "error_value": { "error": "error_description" } }
    @field:JsonProperty("last_number_of_players")
    val lastNumberOfPlayers: Int,
    @field:JsonProperty("inactive_minute_counter")
    @field:JsonDeserialize(using = KTDurationDeserializer::class)
    val inactiveMinuteCounter: Duration,
    @field:JsonProperty("logsecret")
    val logSecret: String,
    @field:JsonProperty("start_instantly")
    val startInstantly: Boolean,
    @field:JsonProperty("end_instantly")
    val endInstantly: Boolean,
    @field:JsonProperty("provisioned")
    val provisioned: Boolean,
    @field:JsonProperty("ended")
    val ended: Boolean,
    @field:JsonProperty("steam_uid")
    val steamUID: String,
    @field:JsonProperty("server")
    val server: ServemeServer,
    @field:JsonProperty("progress")
    val progress: Optional<ServemeReservationProgress>,
    @field:JsonProperty("log_uploads")
    val logUploads: Optional<List<String>>,
    @field:JsonProperty("zipfile_url")
    val zipfileURL: Optional<String>,
)