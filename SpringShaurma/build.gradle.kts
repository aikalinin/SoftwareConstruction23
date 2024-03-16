import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
}

group = "com.kpo"
version = "0.0.1-SNAPSHOT"
description = "spring-shaurma"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator:3.0.5")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.0.5")
    implementation("org.springframework.boot:spring-boot-starter-web:3.0.5")
    implementation("org.projectlombok:lombok:1.18.26")
    runtimeOnly("org.springframework.boot:spring-boot-devtools:3.0.5")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.0.5")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
