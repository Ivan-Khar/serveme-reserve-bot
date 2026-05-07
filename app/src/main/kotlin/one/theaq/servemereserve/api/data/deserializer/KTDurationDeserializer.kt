package one.theaq.servemereserve.api.data.deserializer

import tools.jackson.core.JsonParser
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.ValueDeserializer
import kotlin.time.Duration

class KTDurationDeserializer: ValueDeserializer<Duration>() {
    override fun deserialize(
        jsonParser: JsonParser,
        context: DeserializationContext
    ): Duration? {
        try {
            val seconds = jsonParser.intValue
            return Duration.parse("${seconds}s")
        } catch (ex: IllegalArgumentException) {
            print("Couldn't parse Duration: $ex")
            return null
        }
    }
}