package one.theaq.servemereserve.discord.bot.command

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import one.theaq.servemereserve.discord.bot.command.argument.CommandArgument

abstract class SlashCommand() {
    private var id: String = ""
    private val arguments: List<CommandArgument<*>> = emptyList()

    fun getID(): String {
        return id
    }

    fun getArguments(): List<CommandArgument<*>> {
        return arguments
    }

    open fun onCommand(event: SlashCommandInteractionEvent) {

    }

    private fun setID(id: String) {
        this.id = id
    }

    class Builder(val id: String, val slashCommand: SlashCommand) {
        init {
            slashCommand.setID(id)
        }

        fun build(): SlashCommand {
            if (slashCommand.getID().isEmpty()) throw IllegalArgumentException("ID cant be empty")

            return slashCommand
        }
    }
}