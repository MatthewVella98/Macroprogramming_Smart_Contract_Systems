package com.parser.model;

// This class represents a function parameter in @X... block
public class ParameterDeclaration {
    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ParameterDeclaration{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
