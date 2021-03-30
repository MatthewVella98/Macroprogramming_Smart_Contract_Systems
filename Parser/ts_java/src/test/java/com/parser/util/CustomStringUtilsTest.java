package com.parser.util;

import org.junit.Assert;
import org.junit.Test;

// These tests check manipulations with strings
public class CustomStringUtilsTest {

    @Test
    //@Ignore
    public void UtilityTest1() {
        String original = " 111      ";
        String result = CustomStringUtils.trimTrailingSpaces(original);
        System.out.println(result);
        Assert.assertEquals(" 111", result);

        original = " 111";
        result = CustomStringUtils.trimTrailingSpaces(original);
        System.out.println(result);
        Assert.assertEquals(" 111", result);

        original = "";
        result = CustomStringUtils.trimTrailingSpaces(original);
        System.out.println(result);
        Assert.assertEquals("", result);
    }

    @Test
    //@Ignore
    public void Utilitytest2() {
        String original = "     ";
        String result = CustomStringUtils.trimTrailingSpaces(original);
        System.out.println(result);
        Assert.assertEquals("", result);
    }

    @Test
    //@Ignore
    public void ShouldGetFileNamePrefixFromControllerNameCase1() {
        String original = "PropertyController";
        String result = CustomStringUtils.getFileNamePrefixFromControllerName(original);
        System.out.println(result);
        Assert.assertEquals("property", result);
    }

    @Test
    //@Ignore
    public void ShouldGetFileNamePrefixFromControllerNameCase2() {
        String original = "ParticipantController";
        String result = CustomStringUtils.getFileNamePrefixFromControllerName(original);
        System.out.println(result);
        Assert.assertEquals("participant", result);
    }

    @Test
    //@Ignore
    public void ShouldGetFolderNameFromControllerNameCase1() {
        String original = "PropertyController";
        String result = CustomStringUtils.getFolderNameFromControllerName(original);
        System.out.println(result);
        Assert.assertEquals("Property", result);
    }

    @Test
    //@Ignore
    public void ShouldGetFolderNameFromControllerNameCase2() {
        String original = "ParticipantController";
        String result = CustomStringUtils.getFolderNameFromControllerName(original);
        System.out.println(result);
        Assert.assertEquals("Participant", result);
    }

}
