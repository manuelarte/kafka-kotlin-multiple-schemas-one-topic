# Example On How To Use Multiple Schemas In One Topic

In this repository you can find different strategies on how to have different [avro schemas](https://avro.apache.org/docs/1.11.1/specification/) in one Kafka Topic.

There are two Kotlin Spring Boot projects using two different strategies. The technologies used are:
- ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) Spring Boot
- ![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white) Kotlin
- ![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka) Apache Kafka


## One Avro Schema For Each Message  

By using [TopicRecordNameStrategy](https://github.com/confluentinc/schema-registry/blob/master/schema-serializer/src/main/java/io/confluent/kafka/serializers/subject/TopicRecordNameStrategy.java), we can create one avro schema per event that we want to produce. This solution is quite elegant since the schemas can evolve differently per topic. The project can be found at [TopicRecordName](./topicrecordname).

### How to Run

In order to run the project we also need to run the kafka broker and the schema registry:

I provide a docker compose file that contains the infrastructure (Kafka + Schema Registry), and after that both are running, we can run the Spring Boot application.

Run the command:
```bash
> cd topicrecordname
> docker compose up && ./gradlew bootRun
```

`./gradlew bootRun` will run the spring boot application with both profiles `producer` and `consumer`, but it's possible to run them separately.

After the application is loaded, you should see that two messages (with **different avro schemas**) have been sent and received *on the same topic*.

```
2024-11-18T19:30:59.290+01:00  INFO 6780 --- [kafka-kotlin] [           main] c.g.manuelarte.kafka.StarterProducer     : Sending new user: {"id": 1, "name": "manuel", "username": "manuelarte", "email": "manuel@manuel.com"}
2024-11-18T19:31:00.386+01:00  INFO 6780 --- [kafka-kotlin] [           main] c.g.manuelarte.kafka.StarterProducer     : Sending user email updated: {"id": 1, "email": "manuel@example.com"}
2024-11-18T19:31:00.530+01:00  INFO 6780 --- [kafka-kotlin] [        1-0-C-1] c.g.m.kafka.listeners.UserListener       : Received new User message: {"id": 1, "name": "manuel", "username": "manuelarte", "email": "manuel@manuel.com"}
2024-11-18T19:31:00.548+01:00  INFO 6780 --- [kafka-kotlin] [        1-0-C-1] c.g.m.kafka.listeners.UserListener       : Received User email updated message: {"id": 1, "email": "manuel@example.com"}
```

You can also check the schemas created in http://localhost:8081/subjects/, they should have the following pattern <topic>-<fully qualified name>:
+ quickstart-events-com.github.manuelarte.kafka.avro.UserEmailUpdated
+ quickstart-events-com.github.manuelarte.kafka.avro.UserNew

## One Avro Schema With A Field With The Union Of Different Events

By default, one topic supports one avro schema, but it's possible to express that one field of that schema can be an union of different types.
As explained [here](https://www.confluent.io/blog/multiple-event-types-in-the-same-kafka-topic/), we can have a payload field of the type union of other different schemas.
Then, we can use the default [TopicNameStrategy](https://github.com/confluentinc/schema-registry/blob/master/schema-serializer/src/main/java/io/confluent/kafka/serializers/subject/TopicNameStrategy.java). The project can be found at [TopicName](./topicname).

### How to Run

In order to run the project we also need to run the kafka broker and the schema registry:

Run the command:

> cd topicname
> docker compose up && ./gradlew bootRun

This command run the spring boot application with the profiles `producer` and `consumer`.

After the application is loaded, you should see that two messages (with **same avro schemas but different payload type**) have been sent and received *on the same topic*.

```
2024-11-18T19:30:59.290+01:00  INFO 6780 --- [kafka-kotlin] [           main] c.g.manuelarte.kafka.StarterProducer     : Sending new user: {"id": 1, "name": "manuel", "username": "manuelarte", "email": "manuel@manuel.com"}
2024-11-18T19:31:00.386+01:00  INFO 6780 --- [kafka-kotlin] [           main] c.g.manuelarte.kafka.StarterProducer     : Sending user email updated: {"id": 1, "email": "manuel@example.com"}
2024-11-18T19:31:00.530+01:00  INFO 6780 --- [kafka-kotlin] [        1-0-C-1] c.g.m.kafka.listeners.UserListener       : Received new User message: {"id": 1, "name": "manuel", "username": "manuelarte", "email": "manuel@manuel.com"}
2024-11-18T19:31:00.548+01:00  INFO 6780 --- [kafka-kotlin] [        1-0-C-1] c.g.m.kafka.listeners.UserListener       : Received User email updated message: {"id": 1, "email": "manuel@example.com"}
```

You can also check the schemas created in http://localhost:8081/subjects/, as we have used the default subject strategy, it should have the following pattern <topic>-<key|value>:
+ quickstart-events-value

## Notes

It is possible to run the `producer` or `consumer` separately. Just use the corresponding profile.

## Resources

- https://www.confluent.io/blog/put-several-event-types-kafka-topic/
- https://www.confluent.io/blog/multiple-event-types-in-the-same-kafka-topic/
- https://developer.confluent.io/courses/schema-registry/schema-subjects/
