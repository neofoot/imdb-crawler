package com.fsoft.z8.ip.entity;

public enum RoleEnum {

    ACTOR("Actor"),
    ACTRESS("Actress"),
    DIRECTOR("Director"),
    WRITER("Writer"),
    PRODUCER("Producer"),
    UNKNOWN("Unknown");

    private String value;

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    public static RoleEnum parse(String value) {
        if (ACTOR.value.equals(value)) {
            return ACTOR;
        } else if (ACTRESS.value.equals(value)) {
            return ACTRESS;
        } else if (DIRECTOR.value.equals(value)) {
            return DIRECTOR;
        } else if (PRODUCER.value.equals(value)) {
            return PRODUCER;
        } else if (WRITER.value.equals(value)) {
            return WRITER;
        }
        return UNKNOWN;
    }

    private RoleEnum(String value) {
        this.value = value;
    }
}
