package one.theaq.servemereserve.api.data.server

data class ServemeServers(
    val servers: Array<ServemeServer> // servers
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ServemeServers

        return servers.contentEquals(other.servers)
    }

    override fun hashCode(): Int {
        return servers.contentHashCode()
    }
}