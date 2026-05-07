package one.theaq.servemereserve.api.data

import java.time.Duration
import java.time.LocalDateTime
import java.util.Optional

data class ServemeUser(
    val id: Int, // id
    val steamUID: String, // uid
    val nickname: String, // nickname
    val name: String, // name // where do they get this value from
    val donator: Boolean, // donator
    val donatorUntil: Optional<LocalDateTime>, // donator_until
    val reservationsMade: Int, // reservations_made
    val totalReservationTime: Duration // total_reservation_seconds
) {}
