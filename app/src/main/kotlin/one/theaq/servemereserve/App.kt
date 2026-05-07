package one.theaq.servemereserve

import one.theaq.servemereserve.api.data.ServemeRegion
import one.theaq.servemereserve.api.request.ServemeAPI

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    val test = ServemeAPI(ServemeRegion.EU, "a")

    println(test.makeRequest("test", ""))
}
