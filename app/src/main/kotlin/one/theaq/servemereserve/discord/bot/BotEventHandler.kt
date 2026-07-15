package one.theaq.servemereserve.discord.bot

import net.dv8tion.jda.api.events.guild.GuildAvailableEvent
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class BotEventHandler(bot: BotHandler): ListenerAdapter() {
    override fun onGuildAvailable(event: GuildAvailableEvent) {
        super.onGuildAvailable(event)
    }

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        super.onSlashCommandInteraction(event)
    }
}