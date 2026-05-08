package one.theaq.servemereserve

import one.theaq.servemereserve.api.data.ServemeRegion
import one.theaq.servemereserve.api.data.reservation.ServemeReservationsRequest
import one.theaq.servemereserve.api.request.ServemeAPI
import kotlin.jvm.java

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    val test = ServemeAPI(ServemeRegion.EU, "")

    print(
        test.requestGET(
            "reservations",
            ServemeReservationsRequest::class.java
        )
    )
}
