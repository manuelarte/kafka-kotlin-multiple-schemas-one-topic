plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
	//id("com.github.davidmc24.gradle.plugin.avro") version "1.9.1"
	//id("com.github.imflog.kafka-schema-registry-gradle-plugin") version "2.1.1"

}
// To autogenerate avro schema java classes
// java -jar /Users/lv90no/Downloads/avro-tools-1.12.0.jar compile schema src/main/resources/schemas/iaas/new.avsc src/main/java/

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

group = "org.ing.p16411.sandbox"
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
