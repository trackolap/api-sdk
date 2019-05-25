package com.trackolap.response;


public class GenericResponse {

    /**
     * API response status
     * 
     */
    private boolean s;

    /** The error details. */
    private String ed;

    private String msg;

    public boolean isS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }

    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



}
