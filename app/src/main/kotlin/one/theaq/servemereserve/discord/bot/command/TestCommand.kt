package one.theaq.servemereserve.discord.bot.command

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

class TestCommand: SlashCommand() {

    override fun onCommand(event: SlashCommandInteractionEvent) {
        event.hook.deleteOriginal().queue()
        event.channel.sendMessage("you dum").queue()
    }

}