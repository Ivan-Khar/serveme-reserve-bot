package one.theaq.servemereserve.discord.bot.command

import one.theaq.servemereserve.discord.bot.command.argument.CommandArgument

abstract class Command(
    val name: String
) {
    val arguments = listOf<CommandArgument<*>>()
}