package one.theaq.servemereserve.discord.bot.event

import dev.minn.jda.ktx.events.CoroutineEventListener
import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import one.theaq.servemereserve.discord.bot.BotHandler

class InteractionEvents(val handler: BotHandler): CoroutineEventListener {
    override suspend fun onEvent(event: GenericEvent) {
        if (event !is GenericInteractionCreateEvent) return

        when(event) {
            is SlashCommandInteractionEvent -> onSlashCommandInteraction(event)
        }
    }

    fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        event.deferReply()
    }
}