![image](../images/confluent-logo-300-2.png)

# Overview

This [docker-compose.yml](docker-compose.yml) launches all services in Confluent Platform and runs them in containers in your local host, enabling you to build your own development environments.
For an example of how to use this Docker setup, refer to the [Confluent Platform quickstart](https://docs.confluent.io/current/quickstart/index.html?utm_source=github&utm_medium=demo&utm_campaign=ch.examples_type.community_content.cp-all-in-one)

# Additional Examples

For additional examples that showcase streaming applications within an event streaming platform, please refer to [these demos](https://github.com/confluentinc/examples).

## Running the example

To run the example: `./run.sh` which will:
  
  - Run `docker-compose up` 
  - Wait for MongoDB, Kafka, Kafka Connect to be ready
  - Register the Confluent Datagen Connector
  - Register the MongoDB Kafka Sink Connector
  - Register the MongoDB Kafka Source Connector
  - Publish some events to Kafka via the Datagen connector
  - Write the events to MongoDB  
  - Write the change stream messages back into Kafka


docker-compose up -d --build