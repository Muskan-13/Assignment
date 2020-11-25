package com.example.staticdesign;


public class Model {
    private String title;
    private String date;
    private String time;
    private String desc;
    private String btntxt;

    public Model(String t,String dt,String tm,String ds,String btn)
    {
        title=t;
        date=dt;
        time=tm;
        desc=ds;
        btntxt=btn;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBtntxt() {
        return btntxt;
    }

    public void setBtntxt(String btntxt) {
        this.btntxt = btntxt;
    }
}
