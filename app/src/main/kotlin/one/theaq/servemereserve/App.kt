package one.theaq.servemereserve

import one.theaq.servemereserve.api.data.ServemeRegion
import one.theaq.servemereserve.api.data.reservation.ServemeReservationsFindRequest
import one.theaq.servemereserve.api.request.ServemeAPI
import java.net.http.HttpRequest
import java.util.Optional

fun main() {
    val apiKey = System.getenv("api_key")
    val test = ServemeAPI(ServemeRegion.EU, apiKey)

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
