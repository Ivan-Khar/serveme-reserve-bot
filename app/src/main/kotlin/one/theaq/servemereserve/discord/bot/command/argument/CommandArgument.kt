package one.theaq.servemereserve.discord.bot.command.argument

import net.dv8tion.jda.api.interactions.commands.OptionType

abstract class CommandArgument<T: Any>(val id: String, val type: OptionType) {
    open val description: String = ""
    open val required: Boolean = false
    open var autocompletion: List<T> = emptyList()

    fun getTypeFromOption() {

    }
}