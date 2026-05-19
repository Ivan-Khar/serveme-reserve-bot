plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.guava)
    implementation(kotlin("reflect"))

    implementation(libs.jda)
    implementation(libs.jdaktx)

    implementation(libs.jacksonCore)
    implementation(libs.jacksonDatabind)
    implementation(libs.jacksonKotlin)

    implementation(libs.logback)
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
