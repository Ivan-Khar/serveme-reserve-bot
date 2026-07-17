package one.theaq.servemereserve.discord.bot.command

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import one.theaq.servemereserve.discord.bot.command.argument.CommandArgument

class TestCommand(
    private val id: String
): SlashCommand {

    override fun getName(): String {
        return id
    }

    override fun getArguments(): List<CommandArgument<*>> {
        return emptyList()
    }

    override fun onCommand(event: SlashCommandInteractionEvent) {
        event.hook.deleteOriginal().queue()
        event.channel.sendMessage("you dum").queue()
    }

}