package com.infosupport.demos.ch6.types;

// Note: compile this class using gradle build
public class JavaPerson {
    private final String name;

    public JavaPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static JavaPerson of(String name){
        return new JavaPerson(name);
    }
}
