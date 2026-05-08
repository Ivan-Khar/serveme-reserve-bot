package one.theaq.servemereserve.api.data.deserializer

import tools.jackson.core.JsonParser
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.ValueDeserializer
import java.util.Optional
import kotlin.time.Duration

class KTOptionalDurationDeserializer: ValueDeserializer<Optional<Duration>>() {
    override fun deserialize(
        jsonParser: JsonParser,
        context: DeserializationContext
    ): Optional<Duration> {
        try {
            val seconds = jsonParser.intValue
            return Optional.of(Duration.parse("${seconds}s"))
        } catch (ex: IllegalArgumentException) {
            print("Couldn't parse Duration: $ex")
            return Optional.empty<Duration>()
        }
    }
}