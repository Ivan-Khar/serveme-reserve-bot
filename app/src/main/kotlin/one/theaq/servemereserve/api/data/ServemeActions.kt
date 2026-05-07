package one.theaq.servemereserve.api.data

import java.net.URL

data class ServemeActions(
    val create: URL,
    val patch: URL,
    val delete: URL
) {}