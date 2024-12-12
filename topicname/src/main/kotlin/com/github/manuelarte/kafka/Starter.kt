package com.github.manuelarte.kafka

import com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent
import com.github.manuelarte.kafka.avro.UserEvent
import com.github.manuelarte.kafka.avro.UserRegisteredEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

interface Starter {
    fun start()
}

@Profile("consumer")
@Component
class StarterConsumer : Starter {
    override fun start() {}
}

@Profile("producer")
@Component
@Primary
class StarterProducer(
    @Value("\${datasources.user.topic}") private val userTopic: String,
    private val kafkaTemplate: KafkaTemplate<String, UserEvent>
) : Starter {

    private val LOGGER: Logger = LoggerFactory
        .getLogger(StarterProducer::class.java)

    override fun start() {
        UserEvent(UserRegisteredEvent(1, "manuel", "manuelarte", "manuel@manuel.com")).also {
            LOGGER.info("Sending new user: {}", it)
            val completeableFuture = this.kafkaTemplate.send(this.userTopic, it)
            completeableFuture.thenApply { result ->
                LOGGER.info("UserRegisteredEvent Sent: {}", result.producerRecord.value())
            }
        }


        UserEvent(UserEmailUpdatedEvent(1, "manuel@example.com")).also {
            LOGGER.info("Sending user email updated: {}", it)
            val completeableFuture1 = this.kafkaTemplate.send(this.userTopic, it)
            completeableFuture1.thenApply { result ->
                LOGGER.info("UserEmailUpdatedEvent Sent: {}", result.producerRecord.value())
            }
        }

    }
}
