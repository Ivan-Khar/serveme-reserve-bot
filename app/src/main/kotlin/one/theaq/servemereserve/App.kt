package one.theaq.servemereserve

import one.theaq.servemereserve.api.data.ServemeRegion
import one.theaq.servemereserve.api.request.ServemeAPI
import one.theaq.servemereserve.discord.bot.BotInit
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class App {
    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger("reserve-bot")
    }
}

fun main() {
    val apiKey = System.getenv("api_key")
    val test = ServemeAPI(ServemeRegion.EU, apiKey)

//    print(
//        test.requestPOST(
//            "reservations/find_servers",
//            Optional.of(HttpRequest.BodyPublishers.ofString(
//                "{}"
//            )),
//            ServemeReservationsFindRequest::class
//        )
//    )

    val bot = BotInit()
}
