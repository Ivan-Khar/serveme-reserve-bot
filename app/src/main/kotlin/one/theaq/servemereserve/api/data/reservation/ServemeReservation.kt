package one.theaq.servemereserve.api.data.reservation

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import one.theaq.servemereserve.api.data.server.ServemeServer
import java.util.Date
import java.util.Optional
import kotlin.time.Duration

@JsonInclude(JsonInclude.Include.ALWAYS)
class ServemeReservation(
    @field:JsonProperty("id")
    val id: Int,
    @field:JsonProperty("status")
    status: ReservationStatus,
    @field:JsonProperty("starts_at")
    startsAt: Date,
    @field:JsonProperty("ends_at")
    endsAt: Date,
    @field:JsonProperty("server_id")
    serverId: Optional<Int>,
    @field:JsonProperty("password")
    password: Optional<String>,
    @field:JsonProperty("rcon")
    rconPassword: Optional<String>,
    @field:JsonProperty("first_map")
    firstMap: Optional<String>,
    @field:JsonProperty("tv_password")
    stvPassword: String,
    @field:JsonProperty("tv_relaypassword")
    stvRelayPassword: String,
    @field:JsonProperty("tv_port")
    stvPort: Optional<Int>,
    @field:JsonProperty("server_config_id")
    configId: Optional<Int>,
    @field:JsonProperty("whitelist_id")
    whitelistId: Optional<Int>,
    @field:JsonProperty("custom_whitelist_id")
    customWhitelistId: Optional<String>,
    @field:JsonProperty("auto_end")
    autoEnd: Boolean,
    @field:JsonProperty("enable_plugins")
    enablePlugins: Boolean,
    @field:JsonProperty("enable_demos_tf")
    enableDemosTF: Boolean,
    @field:JsonProperty("sdr_ip")
    sdrIP: Optional<String>,
    @field:JsonProperty("sdr_port")
    sdrPort: Optional<Int>,
    @field:JsonProperty("sdr_tv_port")
    sdrTVPort: Optional<Int>,
    @field:JsonProperty("sdr_final")
    sdrFinal: Boolean,
    @field:JsonProperty("disable_democheck")
    disableDemocheck: Boolean,
    @field:JsonProperty("democheck_mode")
    democheckMode: ReservationDemomode,
    @field:JsonProperty("errors")
    errors: Optional<Map<String, String>>, // errors { "error_value": { "error": "error_description" } }
    @field:JsonProperty("last_number_of_players")
    val lastNumberOfPlayers: Int,
    @field:JsonProperty("inactive_minute_counter")
    val inactiveMinuteCounter: Optional<Duration>,
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
): ServemeReservationTemplate(status, startsAt, endsAt, serverId, password, rconPassword, firstMap, stvPassword, stvRelayPassword, stvPort, configId, whitelistId, customWhitelistId, autoEnd, enablePlugins, enableDemosTF, sdrIP, sdrPort, sdrTVPort, sdrFinal, disableDemocheck, democheckMode, errors)