package one.theaq.servemereserve.api.data.reservation

import com.fasterxml.jackson.annotation.JsonProperty

enum class ReservationProgressPhase {
    @JsonProperty("creating_vm")
    CREATING_VM,
    @JsonProperty("booting")
    BOOTING_VM,
    @JsonProperty("configuring")
    CONFIGURING,
    @JsonProperty("booting_tf2")
    BOOTING_TF2,
    @JsonProperty("starting_tf2")
    STARTING_TF2
}