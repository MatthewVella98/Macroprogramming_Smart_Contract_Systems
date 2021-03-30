package com.parser.model;

import java.util.ArrayList;
import java.util.List;

public class DataFieldElement {
    private List<String> annotations = new ArrayList<>();
    private String varName;
    private String type;

    public List<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<String> annotations) {
        this.annotations = annotations;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DataFieldElement{" +
                "annotations=" + annotations +
                ", varName='" + varName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
