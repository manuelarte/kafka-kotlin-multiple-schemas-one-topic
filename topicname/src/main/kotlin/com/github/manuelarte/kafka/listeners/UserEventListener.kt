package com.github.manuelarte.kafka.listeners

import com.github.manuelarte.kafka.avro.UserEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.kafka.annotation.KafkaHandler
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
@Profile("consumer")
@KafkaListener(id = "1", topics = ["\${datasources.user.topic}"], groupId = "1")
class UserEventListener {

    private val LOGGER: Logger = LoggerFactory
        .getLogger(UserEventListener::class.java)

    @KafkaHandler
    fun handleNew(user: UserEvent) {
        LOGGER.info("Received User event: {}", user)
    }

}
