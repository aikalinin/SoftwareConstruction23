package ru.hse.software.construction.proxy

interface Connector {
    fun connect()
}

class DbConnector : Connector {
    override fun connect() {}
}

class SecureDbConnector(
    private val connector: Connector
) : Connector {

    override fun connect() {
        // Securing connection
        connector.connect()
        // Securing commit
    }
}

class VerifyDbConnector(
    private val connector: Connector
) : Connector {
    override fun connect() {
        TODO("Not yet implemented")
    }
}

fun createConnector(isSecure: Boolean, isVerify: Boolean) {
    // ...
}

val connector = SecureDbConnector(VerifyDbConnector(DbConnector()))