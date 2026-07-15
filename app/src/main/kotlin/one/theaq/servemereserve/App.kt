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
    val servemeApiKey = System.getenv("api_key") ?: throw UnsupportedOperationException("Serveme API key is null")
    val test = ServemeAPI(ServemeRegion.EU, servemeApiKey)

//    print(
//        test.requestPOST(
//            "reservations/find_servers",
//            Optional.of(HttpRequest.BodyPublishers.ofString(
//                "{}"
//            )),
//            ServemeReservationsFindRequest::class
//        )
//    )
    val discordBotToken = System.getenv("jda_token") ?: throw UnsupportedOperationException("Serveme API key is null")
    val bot = BotInit(discordBotToken)
}
