pluginManagement {
    includeBuild("../jOOQ/jOOQ-codegen-gradle/")
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "gradle-jooq-user"
include(
    "kotlin-app",
    "groovy-app",
)
