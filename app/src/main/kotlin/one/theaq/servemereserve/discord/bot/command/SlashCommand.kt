package one.theaq.servemereserve.discord.bot.command

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import one.theaq.servemereserve.discord.bot.command.argument.CommandArgument

interface SlashCommand {
    fun getArguments(): List<CommandArgument<*>>
    fun onCommand(event: SlashCommandInteractionEvent)
}