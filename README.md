# kafka-kotlin-multiple-schemas-one-topic

Example on how to use multiple [avro schemas](https://avro.apache.org/docs/1.11.1/specification/) in one Kafka Topic

## How to Run

Run the command:


> docker compose up && ./gradlew bootRun

This command run all the docker containers needed:
- kafka
- schema registry
Plus the spring boot application with the profiles producer and consumer.

You should see that two messages (with different avro schemas) have been sent and received on the same topic.

## Resources

- https://www.confluent.io/blog/put-several-event-types-kafka-topic/
- https://developer.confluent.io/courses/schema-registry/schema-subjects/

- Explain how to check the subjects