plugins {
    id("java")
    kotlin("jvm") version "1.8.21"
}

kotlin {
    jvmToolchain(11)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
