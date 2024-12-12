package com.github.manuelarte.kafka.configuration

import com.github.manuelarte.kafka.avro.UserEvent
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig
import io.confluent.kafka.serializers.KafkaAvroSerializer
import io.confluent.kafka.serializers.subject.TopicNameStrategy
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory


@Configuration
@Profile("producer")
class KafkaProducerConfig(
    @Value("\${spring.kafka.bootstrap-servers}") val bootstrapServers: String,
) {
    @Bean
    fun producerFactory(): ProducerFactory<String, UserEvent> =
        DefaultKafkaProducerFactory(mapOf(
            Pair(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers),
            Pair(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java),
            Pair(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer::class.java),
            Pair("auto.register.schemas", true),
            Pair("use.latest.version", true),
            Pair("value.subject.name.strategy", TopicNameStrategy::class.java),
            Pair(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081")
        ))

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, UserEvent> {
        return KafkaTemplate(producerFactory())
    }
}
