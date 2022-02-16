import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.infosupport"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.6.10"
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions {
        jvmTarget = "11"
    }
}
kotlin {
    sourceSets {
        val test by getting {
            dependencies {
                implementation("org.assertj:assertj-core:3.21.0")
                implementation(kotlin("test"))
            }
        }
    }
}
