package com.kpo.springshaurma.model;

public record Ingredient(String id, String name, Type type) {

    public enum Type {
        SAUCE,
        WRAP
    }
}
