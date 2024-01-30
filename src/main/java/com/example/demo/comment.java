package com.example.demo;

public class comment {
    public void setId(Integer id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public comment(Integer id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    private Integer id;
    private String comment;

}
