package com.parser.util;

import org.apache.commons.lang3.StringUtils;

public class CustomStringUtils {

    private static final String CONTROLLER_PATTERN = "Controller";

    public static String trimTrailingSpaces(String original){
        if (StringUtils.isBlank(original)) {
            return "";
        }

        int length = original.length();
        int position = length -1;

        char ch = original.charAt(position);
        while (Character.isWhitespace(ch) && position > 0) {
            position--;
            ch = original.charAt(position);
        }

        return original.substring(0, position + 1);
    }

    public static String getFileNamePrefixFromControllerName(String controllerName) {
        if (StringUtils.isBlank(controllerName)) {
            return "";
        }

        int pos = controllerName.indexOf(CONTROLLER_PATTERN);
        if (pos == -1) return "";

        String prefix = controllerName.substring(0, pos);
        prefix = prefix.substring(0,1).toLowerCase() + prefix.substring(1);

        return prefix;
    }

    public static String getFolderNameFromControllerName(String controllerName) {
        if (StringUtils.isBlank(controllerName)) {
            return "";
        }

        int pos = controllerName.indexOf(CONTROLLER_PATTERN);
        if (pos == -1) return "";

        String prefix = controllerName.substring(0, pos);
        prefix = prefix.substring(0,1).toUpperCase() + prefix.substring(1);

        return prefix;
    }
}
