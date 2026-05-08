package one.theaq.servemereserve.api.data.reservation

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import one.theaq.servemereserve.api.data.deserializer.KTDurationDeserializer
import one.theaq.servemereserve.api.data.deserializer.KTOptionalDurationDeserializer
import one.theaq.servemereserve.api.data.server.ServemeServer
import tools.jackson.databind.annotation.JsonDeserialize
import java.util.Date
import java.util.Optional
import kotlin.time.Duration

@JsonInclude(JsonInclude.Include.ALWAYS)
data class ServemeReservationTemplate(
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
)