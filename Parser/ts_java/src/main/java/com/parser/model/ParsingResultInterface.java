package com.parser.model;

import java.util.List;

public interface ParsingResultInterface {

    public static final String MAIN_SYSTEM_DIR = "MainSystem";
    public static final String PARTICIPANT_DIR = "Participant";
    public static final String PROPERY_DIR = "Property";

    public static final String PROPERTY_MAIN_SYSTEM_MODEL_TS = "PropertyMainSystem.Model.ts";
    public static final String PARTICIPANT_CONTROLLER_TS = "participant.controller.ts";
    public static final String CONTROLLERS_TS = "controllers.ts";
    public static final String PARTICIPANT_MODEL_TS = "participant.model.ts";
    public static final String PROPERTY_MODEL_TS = "property.model.ts";
    public static final String PROPERTY_CONTROLLER_TS = "property.controller.ts";;

    public static final String CONTROLLER_TS_APPENDIX = ".controller.ts";

    public String translate();

    //<file name, file content>
    // In common case can be produced 2 or more files per section in input
    public List<FileEntityResult> getFileEntities();
}
