package com.parser.model;

import java.util.ArrayList;
import java.util.List;

// This class describes data (field) declaration in data block, say, @XOnlyOnChain public propertyType:string;
public class DataTypeElement {
    private String type;
    private boolean readOnly = false;
    List<String> annotations = new ArrayList<>();

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<String> annotations) {
        this.annotations = annotations;
    }
}
