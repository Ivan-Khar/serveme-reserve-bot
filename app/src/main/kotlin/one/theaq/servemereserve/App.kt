package one.theaq.servemereserve

import net.dv8tion.jda.api.requests.Method
import one.theaq.servemereserve.api.data.ServemeRegion
import one.theaq.servemereserve.api.request.ServemeAPI
import java.util.Optional

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    val test = ServemeAPI(ServemeRegion.EU, "a")

    print(test.makeRequest("maps", Method.GET,Optional.empty()))
}
