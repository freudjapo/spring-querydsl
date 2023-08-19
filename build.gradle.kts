import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
    kotlin("kapt") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

object Versions{
    const val QUERY_DSL = "5.0.0"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("com.querydsl:querydsl-jpa:${Versions.QUERY_DSL}:jakarta")
    kapt("com.querydsl:querydsl-apt:${Versions.QUERY_DSL}:jakarta")
    kapt("jakarta.persistence:jakarta.persistence-api")
    testAnnotationProcessor("com.querydsl:querydsl-apt:${Versions.QUERY_DSL}:jakarta")
    testAnnotationProcessor("jakarta.persistence:jakarta.persistence-api")
    testImplementation("com.querydsl:querydsl-jpa:${Versions.QUERY_DSL}:jakarta")

    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
