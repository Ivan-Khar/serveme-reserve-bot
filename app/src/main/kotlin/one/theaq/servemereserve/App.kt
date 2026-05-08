package one.theaq.servemereserve

import one.theaq.servemereserve.api.data.ServemeRegion
import one.theaq.servemereserve.api.data.reservation.ServemeReservationsFindRequest
import one.theaq.servemereserve.api.request.ServemeAPI
import java.net.http.HttpRequest
import java.util.Optional

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    val test = ServemeAPI(ServemeRegion.EU, "")

    print(
        test.requestPOST(
            "reservations/find_servers",
            Optional.of(HttpRequest.BodyPublishers.ofString(
                "{}"
            )),
            ServemeReservationsFindRequest::class
        )
    )
}
