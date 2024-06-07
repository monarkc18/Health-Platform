package com.Lattice.Task.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum City {
    DELHI, NOIDA, FARIDABAD;
    @JsonCreator
    public static City fromValue(String value) {
        for (City city : City.values()) {
            if (city.name().equalsIgnoreCase(value)) {
                return city;
            }
        }
        throw new IllegalArgumentException("Unknown city: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
