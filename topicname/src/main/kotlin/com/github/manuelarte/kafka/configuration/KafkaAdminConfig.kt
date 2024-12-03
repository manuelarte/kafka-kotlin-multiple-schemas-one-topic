package com.github.manuelarte.kafka.configuration

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaAdminConfig(
    @Value("\${spring.kafka.bootstrap-servers}") val bootstrapServers: String,
    @Value("\${datasources.user.topic}") val iaasTopic: String,
) {

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        return KafkaAdmin(mapOf(
            Pair(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers),
        ))
    }

    @Bean
    fun topic1(): NewTopic {
        return NewTopic(this.iaasTopic, 1, 1.toShort())
    }
}