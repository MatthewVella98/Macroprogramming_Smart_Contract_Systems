package com.parser.model;

/* This class describes text block in the output file: text and it's position => Main class
   First we output blocks with less numbers. Start with 0. Then we output blocks with position 1 if present and so on
   Position 0 will have hardcoded blocks with imports or constructions with starting bracket {
   For instance, position 100 will have a closing bracket } - hardcoded content as well (has to be placed anyway). */
   
public class FileEntityResult {

    private String content;
    private int positionInFile;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPositionInFile() {
        return positionInFile;
    }

    public void setPositionInFile(int positionInFile) {
        this.positionInFile = positionInFile;
    }


}
