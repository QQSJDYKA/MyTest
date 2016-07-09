package com.example.mytest;

/**
 * Created by Administrator on 2016/7/9.
 */
public class Photo {

    private String name;
    private String number;
    private String title;
    private String size;
    private String path;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "com.example.administrator.myapplication.Photo{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
