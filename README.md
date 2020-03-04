# Visión general
Este docker-compose.yml lanza todos los servicios en Confluent Platform con el conector de mongo y los ejecuta en contenedores en su host local, lo que le permite construir tu propios entorno de desarrollo.
MongoDB Kafka Source Connector mueve los datos de un conjunto de réplicas MongoDB a un clúster Kafka. El conector configura y consume documentos de eventos de secuencia de cambios y los publica en un topic.
En el fichero mongo-connector.json se incluye la configuración del conector de mongo
También incluye una pequeña aplicación Spring Boot que consumirá del topic donde publique los eventos mongo

## Ejecutando el ejemplo
  
  - Nos situamos en la ruta `resources/docker` 
  - Ejecutar `docker-compose up -d --build` 
  - Esperamos a que MongoDB, Kafka, Kafka Connect estén ready lo podemos comprobar con `docker-compose ps` si el estado no es Up, entonces ejecutamos `docker-compose up -d`
  - Si queremos podemos configurar un mongo en modo replica-set (este paso no es obligatorio) para ello ejecutamos el fichero ubicado en `resources/mongo/configure-replica-set.sh`  
  - Registramos el MongoDB Kafka Source Connector para ello configuramos el fichero ubicado en `resources/connector/mongo-connector.json` con la conexión de mongo y ejecutamos el siguiente comando curl:
    curl -X POST -H "Content-Type: application/json" --data `resources/connector/mongo-connector.json` http://localhost:8083/connectors -w "\n"
  - Ejecutamos algunos cambios en la base de datos de mongo para que se registren los eventos
  - Podemos acceder a los topics a traves del control center de confluent en http://localhost:9021/clusters
  - También se incluye una aplicación Spring Boot que consumira del topic donde se publican los eventos de mongo
