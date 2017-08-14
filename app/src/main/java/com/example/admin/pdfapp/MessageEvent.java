package com.example.admin.pdfapp;

/**
 * Created by Admin on 8/13/2017.
 */

public class MessageEvent {

    public String message;

    public MessageEvent(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String time){
        this.message = time;
    }
}
