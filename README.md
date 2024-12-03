# Example On How To Use Multiple Schemas In One Topic

In this repository you can find different strategies on how to have different [avro schemas](https://avro.apache.org/docs/1.11.1/specification/) in one Kafka Topic.

There are two Kotlin Spring Boot projects using two different strategies:

## One Avro Schema For Each Message  

By using [TopicRecordNameStrategy](https://github.com/confluentinc/schema-registry/blob/master/schema-serializer/src/main/java/io/confluent/kafka/serializers/subject/TopicRecordNameStrategy.java), we can create one avro schema per event that we want to produce. This solution is quite elegant since the schemas can evolve differently per topic. The project can be found at [TopicRecordName](./topicrecordname).

### How to Run

In order to run the project we also need to run the kafka broker and the schema registry:

Run the command:

> cd topicrecordname
> docker compose up && ./gradlew bootRun

This command run the spring boot application with the profiles `producer` and `consumer`.

You should see that two messages (with different avro schemas) have been sent and received on the same topic.

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

You should see that two messages (same avro schema but the payload field is different) have been sent and received on the same topic.

You can also check the schemas created in http://localhost:8081/subjects/, as we have used the default subject strategy, it should have the following pattern <topic>-<key|value>:
+ quickstart-events-value

## Notes

It is possible to run the `producer` or `consumer` separately. Just use the corresponding profile.

## Resources

- https://www.confluent.io/blog/put-several-event-types-kafka-topic/
- https://www.confluent.io/blog/multiple-event-types-in-the-same-kafka-topic/
- https://developer.confluent.io/courses/schema-registry/schema-subjects/