package one.theaq.servemereserve.api.data.user

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date
import java.util.Optional
import kotlin.time.Duration

data class ServemeUser(
    val id: Int, // id
    @field:JsonProperty("uid")
    val steamUID: String, // uid
    val nickname: String, // nickname
    val name: String, // name // where do they get this value from
    val donator: Boolean, // donator
    @field:JsonProperty("donator_until")
    val donatorUntil: Optional<Date>, // donator_until
    @field:JsonProperty("reservations_made")
    val reservationsMade: Int, // reservations_made
    @field:JsonProperty("total_reservation_seconds")
    val totalReservationTime: Duration // total_reservation_seconds
)