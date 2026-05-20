@file:Suppress("unused")

package one.theaq.servemereserve.discord.bot

import dev.minn.jda.ktx.events.CoroutineEventManager
import dev.minn.jda.ktx.jdabuilder.intents
import dev.minn.jda.ktx.jdabuilder.light
import net.dv8tion.jda.api.requests.GatewayIntent
import one.theaq.servemereserve.App
import one.theaq.servemereserve.discord.bot.event.GuildEvents
import one.theaq.servemereserve.discord.bot.event.InteractionEvents
import one.theaq.servemereserve.discord.bot.event.MessageEvents

class BotInit {
    val token: String = System.getenv("jda_token")
    val botHandler = BotHandler()
    val jda = light(token, enableCoroutines = true) {
        setEventManager(CoroutineEventManager())

        intents += listOf(
            GatewayIntent.MESSAGE_CONTENT,
            GatewayIntent.DIRECT_MESSAGES,
            GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.GUILD_MESSAGE_REACTIONS,
        )

        addEventListeners(
            MessageEvents(botHandler),
            InteractionEvents(botHandler),
            GuildEvents(botHandler)
        )
    }

    init {
        App.LOGGER.info("test")
    }

}