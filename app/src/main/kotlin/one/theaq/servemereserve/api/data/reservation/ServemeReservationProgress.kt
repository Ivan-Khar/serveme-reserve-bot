package one.theaq.servemereserve.api.data.reservation

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Optional

data class ServemeReservationProgress(
    @field:JsonProperty("current_phase")
    val phase: Optional<ReservationProgressPhase>,
    @field:JsonProperty("completed")
    val completed: Boolean,
    @field:JsonProperty("phase_elapsed")
    val phaseElapsed: Int
)
