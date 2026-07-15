@file:Suppress("unused")

package one.theaq.servemereserve.discord.bot

import dev.minn.jda.ktx.events.CoroutineEventManager
import dev.minn.jda.ktx.jdabuilder.intents
import dev.minn.jda.ktx.jdabuilder.light
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.requests.GatewayIntent
import one.theaq.servemereserve.App

class BotInit(token: String) {

    val jda: JDA = light(token, enableCoroutines = true) {
        setEventManager(CoroutineEventManager())

        intents += listOf(
            GatewayIntent.MESSAGE_CONTENT,
            GatewayIntent.DIRECT_MESSAGES,
            GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.GUILD_MESSAGE_REACTIONS,
        )
    }
    val botHandler: BotHandler = BotHandler(jda)

    init {
        App.LOGGER.info("test")
    }

}