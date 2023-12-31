plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    id("application")
    id("org.jooq.jooq-codegen-gradle")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    //implementation(libs.guava)
}

//testing {
//    suites {
//        // Configure the built-in test suite
//        val test by getting(JvmTestSuite::class) {
//            // Use JUnit Jupiter test framework
//            useJUnitJupiter("5.10.0")
//        }
//    }
//}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("gradle.jooq.user.App")
}

jooq {
    configuration {
        logging = org.jooq.meta.jaxb.Logging.WARN
        generator {
            database {
                name = "org.jooq.meta.extensions.ddl.DDLDatabase"
                properties {
                    property {
                        key = "sql"
                        value = """
                            CREATE TABLE IF NOT EXISTS users (
                                id INT NOT NULL AUTO_INCREMENT,
                                first_name VARCHAR(255) NOT NULL,
                                last_name VARCHAR(255) NOT NULL,
                                PRIMARY KEY (id)
                            );
                        """.trimIndent()
                    }
                }
                inputSchema = "S"
            }
            target {
                directory = "${projectDir}/src/generated/jooq"
            }
        }
    }
}
