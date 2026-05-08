package one.theaq.servemereserve.api.data.reservation

import java.util.Optional

data class ServemeActions(
    val create: Optional<String>,
    val patch: Optional<String>,
    val delete: Optional<String>
)