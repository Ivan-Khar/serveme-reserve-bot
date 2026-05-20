package one.theaq.servemereserve.discord.bot.event

import dev.minn.jda.ktx.events.CoroutineEventListener
import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.events.message.GenericMessageEvent
import net.dv8tion.jda.api.events.message.MessageDeleteEvent
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent
import one.theaq.servemereserve.App
import one.theaq.servemereserve.discord.bot.BotHandler

class MessageEvents(val handler: BotHandler): CoroutineEventListener {
    override suspend fun onEvent(event: GenericEvent) {
        if (event !is GenericMessageEvent) return

        when(event) {
            is MessageReceivedEvent -> messageReceived(event)
            is MessageDeleteEvent -> messageDeleted(event)
            is MessageReactionAddEvent -> messageReacted(event)
            is MessageReactionRemoveEvent -> messageUnreacted(event)
        }
    }

    fun messageReceived(event: MessageReceivedEvent) {
        App.LOGGER.info("ReceivedEvent from ${event.author}: ${event.message}")
        handler
    }

    fun messageDeleted(event: MessageDeleteEvent) {
        App.LOGGER.info("DeleteEvent in ${event.guild.id} ${event.channel.id}: ${event.messageId}")
    }

    fun messageReacted(event: MessageReactionAddEvent) {
        App.LOGGER.info("ReactionAdd in ${event.messageId}: ${event.reaction}")
    }

    fun messageUnreacted(event: MessageReactionRemoveEvent) {
        App.LOGGER.info("ReactionRemove in ${event.messageId}: ${event.reaction}")
    }
}