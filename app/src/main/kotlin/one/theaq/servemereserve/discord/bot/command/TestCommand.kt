package one.theaq.servemereserve.discord.bot.command

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import one.theaq.servemereserve.discord.bot.command.argument.CommandArgument

class TestCommand(
    name: String
): SlashCommand {
    override fun getArguments(): List<CommandArgument<*>> {
        TODO("Not yet implemented")
    }

    override fun onCommand(event: SlashCommandInteractionEvent) {

    }

}