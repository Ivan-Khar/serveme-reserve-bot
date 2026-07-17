package one.theaq.servemereserve.discord.bot

import net.dv8tion.jda.api.events.guild.GuildAvailableEvent
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class BotEventHandler(val bot: Bot): ListenerAdapter() {
    override fun onGuildAvailable(event: GuildAvailableEvent) {
       bot.commandRegistry.registerAllCommands(event.guild)
    }

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        event.deferReply().setEphemeral(true).queue()

        val optionalSlashCommand = bot.commandRegistry.getSlashCommandByName(event.name)
        if (optionalSlashCommand.isEmpty) { event.hook.editOriginal("That slash command doesn't exists...").queue(); return }

        val slashCommand = optionalSlashCommand.get()
        slashCommand.onCommand(event)
    }
}