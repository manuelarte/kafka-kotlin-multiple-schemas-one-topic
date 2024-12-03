plugins {
	kotlin("jvm") version "2.1.0"
	kotlin("plugin.spring") version "2.1.0"
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	//id("com.github.davidmc24.gradle.plugin.avro") version "1.9.1"
	//id("com.github.imflog.kafka-schema-registry-gradle-plugin") version "2.1.1"

}
// To autogenerate avro schema java classes
// java -jar ./lib/avro-tools-1.12.0.jar compile schema src/main/avro/User.avsc src/main/java/

buildscript {
	repositories {
		gradlePluginPortal()
		maven {
			url = uri("https://packages.confluent.io/maven/")
		}
		maven {
			url = uri("https://jitpack.io")
		}
	}
}

group = "com.github.manuelarte.kafka"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	maven {
		url = uri("https://packages.confluent.io/maven")
	}
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.apache.avro:avro:1.12.0")
	implementation("io.confluent:kafka-avro-serializer:7.7.1")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
