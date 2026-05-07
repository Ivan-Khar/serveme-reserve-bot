package one.theaq.servemereserve.api.data.reservation

enum class ReservationStatus {
    ENDED, // Ended
    ENDING, // Ending
    SDR_READY, // SDR Ready
    READY, // Ready
    UPDATING, // Server updating, please be patient
    STARTING, // Starting
    FAILED, // Cloud server failed to start
    WAITING, // Waiting to start
    PROVISIONING, // Cloud server provisioning
    CONFIGURING, // Configuring
}