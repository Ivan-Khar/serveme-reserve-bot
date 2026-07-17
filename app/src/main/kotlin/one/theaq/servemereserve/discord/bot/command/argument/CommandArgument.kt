package one.theaq.servemereserve.discord.bot.command.argument

interface CommandArgument<T> {
    fun getValue(): T
}