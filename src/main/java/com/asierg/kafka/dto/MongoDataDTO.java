package com.asierg.kafka.dto;

public class MongoDataDTO {

    private SchemaDTO schemaDTO;
    private String payload;

    public SchemaDTO getSchemaDTO() {
        return schemaDTO;
    }

    public void setSchemaDTO(SchemaDTO schemaDTO) {
        this.schemaDTO = schemaDTO;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "schema=" + schemaDTO +
                ", payload='" + payload + '\'' +
                '}';
    }
}
