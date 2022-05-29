package com.example.psg_itech;

public class ModelClass {

    private String imageView1;
    private String textview1;
    private String textview2;
    private String textview3;
    private String textview4;
    private String textview5;
    private String textview6;
    //private String divider;

    public  ModelClass(){

    }


    public ModelClass(String imageView1, String textview1, String textview2, String textview3, String textview4, String textview5, String textview6) {
        this.imageView1=imageView1;
        this.textview1=textview1;
        this.textview2=textview2;
        this.textview3=textview3;
        this.textview4=textview4;
        this.textview5=textview5;
        this.textview6=textview6;
        //this.divider=divider;
    }

    public String getImageView1() {
        return imageView1;
    }

    public String getTextview1() {
        return textview1;
    }

    public String getTextview2() {
        return textview2;
    }

    public String getTextview3() {
        return textview3;
    }

    public String getTextview4() {
        return textview4;
    }

    public String getTextview5() {
        return textview5;
    }

    public String getTextview6() {
        return textview6;
    }

    //public String getDivider() {
        //return divider;
    //}

    public void setImageView1(String imageView1) {
        this.imageView1 = imageView1;
    }

    public void setTextview1(String textview1) {
        this.textview1 = textview1;
    }

    public void setTextview2(String textview2) {
        this.textview2 = textview2;
    }

    public void setTextview3(String textview3) {
        this.textview3 = textview3;
    }

    public void setTextview4(String textview4) {
        this.textview4 = textview4;
    }

    public void setTextview5(String textview5) {
        this.textview5 = textview5;
    }

    public void setTextview6(String textview6) {
        this.textview6 = textview6;
    }

    //public void setDivider(String divider) {
      //  this.divider = divider;
    //}
}
