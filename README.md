# Example Of How To Send/Receive Different Avro Schemas In The Same Kafka Topic

This project contains an example on how to use multiple [AVRO schemas](https://avro.apache.org/docs/1.11.1/specification/) in one Kafka Topic using:
- Spring Boot ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
- Kotlin ![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)

## How to Run

I provide a docker compose file that contains the infrastructure (Kafka + Schema Registry), and after that both are running, we can run the Spring Boot application.

Run the command:
```bash
> docker compose up && ./gradlew bootRun
```

`./gradlew bootRun` will run the Spring Boot application with both profiles `producer` and `consumer`, but it's possible to run them separately.

After the application is loaded, you should see that two messages (with **different avro schemas**) have been sent and received on the same topic.

```
2024-11-18T19:30:59.290+01:00  INFO 6780 --- [kafka-kotlin] [           main] c.g.manuelarte.kafka.StarterProducer     : Sending new user: {"id": 1, "name": "manuel", "username": "manuelarte", "email": "manuel@manuel.com"}
2024-11-18T19:31:00.386+01:00  INFO 6780 --- [kafka-kotlin] [           main] c.g.manuelarte.kafka.StarterProducer     : Sending user email updated: {"id": 1, "email": "manuel@example.com"}
2024-11-18T19:31:00.530+01:00  INFO 6780 --- [kafka-kotlin] [        1-0-C-1] c.g.m.kafka.listeners.UserListener       : Received new User message: {"id": 1, "name": "manuel", "username": "manuelarte", "email": "manuel@manuel.com"}
2024-11-18T19:31:00.548+01:00  INFO 6780 --- [kafka-kotlin] [        1-0-C-1] c.g.m.kafka.listeners.UserListener       : Received User email updated message: {"id": 1, "email": "manuel@example.com"}
```

## Resources

- https://www.confluent.io/blog/put-several-event-types-kafka-topic/
- https://developer.confluent.io/courses/schema-registry/schema-subjects/
