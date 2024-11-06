package com.github.manuelarte.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaKotlinMultipleSchemasOneTopicApplication(private val starter: Starter): CommandLineRunner {

	private val LOGGER: Logger = LoggerFactory
		.getLogger(KafkaKotlinMultipleSchemasOneTopicApplication::class.java)

	override fun run(vararg args: String?) {
		this.starter.start()
	}
}

fun main(args: Array<String>) {
	runApplication<KafkaKotlinMultipleSchemasOneTopicApplication>(*args)
}
