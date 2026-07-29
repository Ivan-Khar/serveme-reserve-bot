package one.theaq.servemereserve.discord.bot.command

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import one.theaq.servemereserve.discord.bot.command.argument.CommandArgument

abstract class SlashCommand {
    var id: String = ""
        private set
    var description: String = ""
        private set
    val arguments: MutableList<CommandArgument<*>> = mutableListOf()

    open fun onCommand(event: SlashCommandInteractionEvent) {

    }

    private fun addArgument(argument: CommandArgument<*>) {
        if ( arguments.any { it.id == argument.id } ) throw IllegalArgumentException("Argument ${argument.id} already registered")
        this.arguments.addLast(argument)
    }

    class Builder(val id: String, val slashCommand: SlashCommand) {
        init {
            slashCommand.id = id
        }

        fun setDescription(description: String): Builder {
            slashCommand.description = description
            return this
        }

        fun addArgument(argument: CommandArgument<*>): Builder {
            slashCommand.addArgument(argument)
            return this
        }

        fun build(): SlashCommand {
            if (slashCommand.id.isEmpty()) throw IllegalArgumentException("ID cant be empty")
            if (slashCommand.description.isEmpty()) throw IllegalArgumentException("Description cant be empty")

            return slashCommand
        }
    }
}