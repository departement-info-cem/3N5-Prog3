plugins {
    kotlin("jvm") version "2.0.10"
}

group = "org.depinfo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.3")
    implementation("com.github.kotlinx.ast:grammar-kotlin-parser-antlr-kotlin:v0.1.0")
    implementation("com.github.drieks.antlr-kotlin:antlr-kotlin-runtime:v0.1.0")

    // https://mvnrepository.com/artifact/org.jsoup/jsoup
    implementation("org.jsoup:jsoup:1.18.1")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
//    sourceSets {
//        val main by getting {
//            dependencies {
//                api("com.github.kotlinx.ast:grammar-kotlin-parser-antlr-kotlin:v0.1.0")
//            }
//        }
//    }
}