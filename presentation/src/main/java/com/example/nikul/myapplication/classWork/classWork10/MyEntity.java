package com.example.nikul.myapplication.classWork.classWork10;


public class MyEntity {

        private String text = new String("");
        private String textButton = new String(" ");
        private boolean buttonVisible = true;

    public MyEntity(String text, String textButton, boolean buttonVisible) {
        this.text = text;
        this.textButton = textButton;
        this.buttonVisible = buttonVisible;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextButton() {
        return textButton;
    }

    public void setTextButton(String textButton) {
        this.textButton = textButton;
    }

    public boolean isButtonVisible() {
        return buttonVisible;
    }

    public void setButtonVisible(boolean buttonVisible) {
        this.buttonVisible = buttonVisible;
    }
}


