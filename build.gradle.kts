plugins {
    java
    `kotlin-dsl`
    application
    kotlin("jvm") version "1.4.31" apply false
    id("nu.studer.jooq") version "8.0" apply false
}

group = "ru.vk.mistressfilth"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("nu.studer.jooq")
    }

    group = "ru.vk.mistressfilth"
    version = "1.0-SNAPSHOT"

    dependencies {
        annotationProcessor("org.projectlombok:lombok:1.18.22")
        compileOnly("org.projectlombok:lombok:1.18.24")

        implementation("org.jetbrains:annotations:23.0.0")
        implementation("org.flywaydb:flyway-core:9.7.0")
        implementation("org.postgresql:postgresql:42.5.0")

        implementation("org.jooq:jooq:3.15.4")
        implementation("org.jooq:jooq-codegen:3.15.4")
        implementation("org.jooq:jooq-meta:3.15.4")

        implementation("com.google.inject:guice:5.1.0")
        implementation("com.google.inject.extensions:guice-servlet:5.1.0")
        implementation("org.jboss.resteasy:resteasy-guice:4.7.7.Final")
        implementation("org.jboss.resteasy:resteasy-jackson-provider:4.0.0.Beta5")


    }

    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }
}