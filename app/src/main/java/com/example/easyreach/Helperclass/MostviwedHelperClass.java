package com.example.easyreach.Helperclass;

public class MostviwedHelperClass {
    int mv_image;
    String mv_title, mv_description;

    public MostviwedHelperClass(int mv_image, String mv_title, String mv_description) {
        this.mv_image = mv_image;
        this.mv_title = mv_title;
        this.mv_description = mv_description;
    }

    public int getMv_image() {
        return mv_image;
    }

    public String getMv_title() {
        return mv_title;
    }

    public String getMv_description() {
        return mv_description;
    }
}
