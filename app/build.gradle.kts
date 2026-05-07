plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.guava)
    implementation(libs.jda)
    implementation(libs.jacksonCore)
    implementation(libs.jacksonDatabind)
}

@Suppress("UnstableApiUsage", "Unused")
testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("2.3.20")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

application {
    mainClass = "one.theaq.servemereserve.AppKt"
}
