package com.github.manuelarte.kafka.listeners

import com.github.manuelarte.kafka.avro.UserEmailUpdatedEvent
import com.github.manuelarte.kafka.avro.UserRegisteredEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.kafka.annotation.KafkaHandler
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
@Profile("consumer")
@KafkaListener(id = "1", topics = ["\${datasources.user.topic}"], groupId = "1")
class UserListener {

    private val LOGGER: Logger = LoggerFactory
        .getLogger(UserListener::class.java)

    @KafkaHandler
    fun handleNew(userNew: UserRegisteredEvent) {
        LOGGER.info("Received UserRegisteredEvent message: {}", userNew)
    }

    @KafkaHandler
    fun handleUpdate(emailUpdated: UserEmailUpdatedEvent) {
        LOGGER.info("Received UserEmailUpdatedEvent message: {}", emailUpdated)
    }

}
