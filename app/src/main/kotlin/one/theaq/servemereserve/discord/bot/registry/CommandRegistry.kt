package one.theaq.servemereserve.discord.bot.registry

import dev.minn.jda.ktx.interactions.commands.updateCommands
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.interactions.commands.build.Commands
import one.theaq.servemereserve.discord.bot.command.SlashCommand
import one.theaq.servemereserve.discord.bot.command.TestCommand
import java.util.Optional

class CommandRegistry {
    private val commands = HashMap<String, SlashCommand>()

    init {
        register(SlashCommand.Builder("test", TestCommand())

            .build())
    }

    private fun register(slashCommand: SlashCommand) {
        commands[slashCommand.id] = slashCommand
    }

    fun registerAllCommands(guild: Guild) {
        guild.updateCommands {
            commands.forEach { (commandID, command) ->
                val discordCommand = Commands.slash(commandID, command.description)
                command.arguments.forEach { discordCommand.addOption(it.type, it.id, it.description, it.required, it.autocompletion.isNotEmpty() && it.type.canSupportChoices()) }

                addCommands(discordCommand)
            }

            submit()
        }
    }

    fun getSlashCommandByName(name: String): Optional<SlashCommand> {
        return Optional.ofNullable(commands[name])
    }
}