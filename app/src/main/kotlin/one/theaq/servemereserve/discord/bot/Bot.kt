package one.theaq.servemereserve.discord.bot

import net.dv8tion.jda.api.JDA
import one.theaq.servemereserve.discord.bot.registry.CommandRegistry

class Bot(val jda: JDA) {
    val commandRegistry = CommandRegistry()

    init {
        jda.addEventListener(BotEventHandler(this))
    }
}