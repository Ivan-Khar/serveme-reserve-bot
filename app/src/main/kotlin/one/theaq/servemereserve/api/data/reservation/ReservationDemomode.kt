package one.theaq.servemereserve.api.data.reservation

import com.fasterxml.jackson.annotation.JsonProperty

enum class ReservationDemomode {
    @field:JsonProperty("kick")
    KICK, // kick
    @field:JsonProperty("warn")
    WARN, // warn
    @field:JsonProperty("disable")
    DISABLE // disable
}