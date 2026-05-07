package one.theaq.servemereserve.api.data.reservation

import one.theaq.servemereserve.api.data.ServemeServer
import java.net.URL
import java.time.LocalDateTime
import kotlin.time.Duration

// TODO: make all nulls become -1 or empty strings
//      should be the case for all data objects
data class ServemeReservation(
    val status: ReservationStatus, // status
    val startsAt: LocalDateTime, // starts_at
    val endsAt: LocalDateTime, // ends_at
    val serverId: Int, //server_id // nullable
    val password: String, // password // nullable
    val rconPassword: String, // rcon // nullable
    val firstMap: String, // first_map // nullable
    val stvPassword: String, // tv_password
    val stvRelayPassword: String, // tv_relaypassword
    val stvPort: Int, // tv_port // nullable
    val configId: Int, // server_config_id // nullable
    val whitelistId: Int, // whitelist_id // nullable
    val customWhitelistId: Int, // custom_whitelist_id // nullable
    val autoEnd: Boolean, // auto_end
    val enablePlugins: Boolean, // enable_plugins
    val enableDemosTF: Boolean, // enable_demos_tf
    val sdrIP: URL, // sdr_ip
    val sdrPort: Int, // sdr_port
    val sdrTVPort: Int, // sdr_tv_port
    val sdrFinal: Boolean, // sdr_final
    val disableDemocheck: Boolean, // disable_democheck
    val democheckMode: ReservationDemomode, // democheck_mode
    val id: Int, // id
    val lastNumberOfPlayers: Int, // last_number_of_players
    val inactiveMinuteCounter: Duration, // inactive_minute_counter
    val logSecret: String, // logsecret
    val startInstantly: Boolean, // start_instantly
    val endInstantly: Boolean, // end_instantly
    val provisioned: Boolean, // provisioned
    val ended: Boolean, // ended
    val steamUID: String, // steam_uid
    val server: ServemeServer, // server
    val logUploads: List<String>, // log_uploads // TODO: figure out the right data type
    val zipfileURL: URL, // zipfile_url
) {}