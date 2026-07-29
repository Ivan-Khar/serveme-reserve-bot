package one.theaq.servemereserve.discord.bot.command.argument

import net.dv8tion.jda.api.interactions.commands.OptionType

class StringCommandArgument(id: String, type: OptionType) : CommandArgument<String>(id, type) {
    override val description: String
        get() = "a"
}