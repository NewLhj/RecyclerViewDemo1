package com.example.administrator.recyclerview;

/**
 * Created by Administrator on 2017/8/9.
 */
public class News {

    public News(int kind, String string) {
        this.kind = kind;
        this.string = string;
    }

    private int kind;
    private String string;

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
