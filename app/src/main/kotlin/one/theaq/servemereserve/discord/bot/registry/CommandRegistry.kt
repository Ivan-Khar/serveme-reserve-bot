package one.theaq.servemereserve.discord.bot.registry

import dev.minn.jda.ktx.interactions.commands.updateCommands
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.interactions.commands.build.Commands
import one.theaq.servemereserve.discord.bot.command.SlashCommand

class CommandRegistry {
    private val commands = HashMap<String, SlashCommand>()

    private fun register() {

    }

    fun registerAllCommands(guild: Guild) {
        guild.updateCommands {
            commands.forEach { (commandID, command) ->
                val command = Commands.slash(commandID, "")

                addCommands(command)
            }

            submit()
        }
    }
}