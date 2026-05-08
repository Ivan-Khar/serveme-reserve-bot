package one.theaq.servemereserve.api.data.reservation

import com.fasterxml.jackson.annotation.JsonProperty

enum class ReservationStatus {
    @field:JsonProperty("Ended")
    ENDED, // Ended
    @field:JsonProperty("Ending")
    ENDING, // Ending
    @field:JsonProperty("SDR Ready")
    SDR_READY, // SDR Ready
    @field:JsonProperty("Ready")
    READY, // Ready
    @field:JsonProperty("Server updating, please be patient")
    UPDATING, // Server updating, please be patient
    @field:JsonProperty("Starting")
    STARTING, // Starting
    @field:JsonProperty("Cloud server failed to start")
    FAILED, // Cloud server failed to start
    @field:JsonProperty("Waiting to start")
    WAITING, // Waiting to start
    @field:JsonProperty("Cloud server provisioning")
    PROVISIONING, // Cloud server provisioning
    @field:JsonProperty("Configuring")
    CONFIGURING, // Configuring
    @field:JsonProperty("Unknown")
    UNKNOWN, // Unknown
}