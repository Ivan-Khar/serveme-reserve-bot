package one.theaq.servemereserve.api.data.reservation

import com.fasterxml.jackson.annotation.JsonProperty
import one.theaq.servemereserve.api.data.server.ServemeServer

data class ServemeReservationsFindRequest(
    @field:JsonProperty("reservation")
    val reservationTemplate: ServemeReservationTemplate,
    @field:JsonProperty("actions")
    val actions: ServemeActions,
    @field:JsonProperty("servers")
    val servers: List<ServemeServer>,
    @field:JsonProperty("server_configs")
    val serverConfigs: List<ServemeFile>,
    @field:JsonProperty("whitelists")
    val serverWhitelists: List<ServemeFile>,
)