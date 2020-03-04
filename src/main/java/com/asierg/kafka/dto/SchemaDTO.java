package com.asierg.kafka.dto;

public class SchemaDTO {

    private String type;
    private boolean optional;

    @Override
    public String toString() {
        return "Schema{" +
                "type='" + type + '\'' +
                ", optional=" + optional +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }
}
