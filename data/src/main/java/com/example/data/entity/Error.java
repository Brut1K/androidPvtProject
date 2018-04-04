package com.example.data.entity;



public class Error extends Exception {


    private ErrorType friendlyError;


    public Error(ErrorType friendlyError) {
        this.friendlyError = friendlyError;
    }

    public ErrorType getFriendlyError() {
        return friendlyError;
    }
}
