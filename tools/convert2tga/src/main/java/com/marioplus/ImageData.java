package com.marioplus;

public class ImageData {

    private static final String STATE_SUCCESS = "SUCCESS";
    private static final String STATE_ERROR = "ERROR";

    private String filename;
    private String ext;
    private String server;
    private String state;

    private String result;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
