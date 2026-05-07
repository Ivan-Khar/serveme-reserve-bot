package one.theaq.servemereserve.api.data

import java.net.URL
import java.util.Optional

data class ServemeActions(
    val create: Optional<URL>,
    val patch: Optional<URL>,
    val delete: Optional<URL>
) {}