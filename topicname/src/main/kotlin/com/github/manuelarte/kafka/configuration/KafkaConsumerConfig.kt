package com.github.manuelarte.kafka.configuration

import com.github.manuelarte.kafka.avro.User
import io.confluent.kafka.serializers.KafkaAvroDeserializer
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig
import io.confluent.kafka.serializers.subject.TopicNameStrategy
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory


@Configuration
@EnableKafka
@Profile("consumer")
class KafkaConsumerConfig(
    @Value("\${spring.kafka.bootstrap-servers}") val bootstrapServers: String,
) {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, User> =
        DefaultKafkaConsumerFactory(mapOf(
            Pair(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers),
            Pair(ConsumerConfig.GROUP_ID_CONFIG, 0),
            Pair(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java),
            Pair(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer::class.java),
            Pair(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true),
            Pair("value.subject.name.strategy", TopicNameStrategy::class.java),
            Pair(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081")
        ))

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, User> {
        return ConcurrentKafkaListenerContainerFactory<String, User>().apply {
                consumerFactory = consumerFactory()
            }
    }

}