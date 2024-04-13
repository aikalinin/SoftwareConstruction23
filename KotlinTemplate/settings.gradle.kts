pluginManagement {
    val kotlinJvmPluginVersion: String by settings
    val springBootVersion: String by settings
    val dependencyManagementPluginVersion: String by settings

    plugins {
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version dependencyManagementPluginVersion
        kotlin("jvm") version kotlinJvmPluginVersion
        kotlin("plugin.spring") version kotlinJvmPluginVersion
        kotlin("plugin.jpa") version kotlinJvmPluginVersion
    }
}

rootProject.name = "kotlin-template"
