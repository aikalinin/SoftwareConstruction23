package ru.hse.software.construction.builder

class DatabaseConnectorWithoutBuilder(
    var user: String? = null,
    var password: String? = null,
    var security: Security? = null
) {

    class Security(
        var certificate: String,
        var key: String
    )
}

class DatabaseConnector {

    private var user: String? = null
    private var password: String? = null
    private var security: Security? = null

    internal class Security {
        var certificate: String? = null
        var key: String? = null
    }

    class DatabaseConnectorBuilder {

        private val databaseConnector = DatabaseConnector()
        fun user(username: String): DatabaseConnectorBuilder {
            databaseConnector.user = username
            return this
        }

        fun password(password: String): DatabaseConnectorBuilder {
            databaseConnector.password = password
            return this
        }

        fun certificate(certificate: String): DatabaseConnectorBuilder {
            if (databaseConnector.security != null) {
                databaseConnector.security?.certificate = certificate
            } else {
                databaseConnector.security = Security()
                databaseConnector.security?.certificate = certificate
            }
            return this
        }

        fun build(): DatabaseConnector {
            return databaseConnector
        }
    }

    companion object {
        fun builder(): DatabaseConnectorBuilder = DatabaseConnectorBuilder()
    }
}

fun builderExample() {

    val databaseConnectorWithoutBuilder =
        DatabaseConnectorWithoutBuilder(
            "user",
            "password",
            DatabaseConnectorWithoutBuilder.Security(
                "certificate",
                "key"
            )
        )

    val databaseConnector = DatabaseConnector.builder()
        .user("user")
        .password("password")
        .certificate("certificate")
        .build()
}