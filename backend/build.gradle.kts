import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.4.32"
    id("org.springframework.boot") version "2.4.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    kotlin("plugin.spring") version "1.4.32"
    application
}

group = "xyz.engsmyre"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.data:spring-data-redis:2.5.4")
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.4")
    implementation("org.springframework.boot:spring-boot-starter-websocket:2.5.4")
    implementation("commons-io:commons-io:2.11.0")
    implementation("redis.clients:jedis:3.6.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.5.4")
    developmentOnly("org.springframework.boot:spring-boot-starter-actuator:2.5.4")
    developmentOnly("org.springframework.boot:spring-boot-devtools:2.5.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.4")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}