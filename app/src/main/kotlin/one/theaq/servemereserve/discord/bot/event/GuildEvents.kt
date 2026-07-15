package one.theaq.servemereserve.discord.bot.event

import dev.minn.jda.ktx.events.CoroutineEventListener
import dev.minn.jda.ktx.interactions.commands.updateCommands
import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.events.guild.GenericGuildEvent
import net.dv8tion.jda.api.events.guild.GuildAvailableEvent
import net.dv8tion.jda.api.events.guild.GuildReadyEvent
import net.dv8tion.jda.api.interactions.commands.build.Commands
import one.theaq.servemereserve.App
import one.theaq.servemereserve.discord.bot.BotHandler

class GuildEvents(val handler: BotHandler): CoroutineEventListener {
    override suspend fun onEvent(event: GenericEvent) {
        if (event !is GenericGuildEvent) return

        when (event) {
            is GuildAvailableEvent -> onGuildAvailable(event)
            is GuildReadyEvent -> onGuildAvailable(event)
        }
    }

    fun onGuildAvailable(event: GenericGuildEvent) {
        App.LOGGER.info("guild ${event.guild} available")

        event.guild.updateCommands {
            val commands = listOf(
                Commands.slash("test", "test guild command.")
            )

            addCommands(commands).submit()
        }
    }
}