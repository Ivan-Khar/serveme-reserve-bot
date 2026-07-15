package one.theaq.servemereserve.discord.bot

import net.dv8tion.jda.api.JDA
import one.theaq.servemereserve.discord.bot.command.CommandRegistry
import one.theaq.servemereserve.discord.bot.event.GuildEvents
import one.theaq.servemereserve.discord.bot.event.InteractionEvents
import one.theaq.servemereserve.discord.bot.event.MessageEvents

class BotHandler(jda: JDA) {
    val commandRegistry = CommandRegistry()

    init {
        jda.addEventListener(
            MessageEvents(this),
            InteractionEvents(this),
            GuildEvents(this)
        )
    }
}