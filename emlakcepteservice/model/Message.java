package com.emlakcepteservice.model;

public class Message {
    private Long id;
    private String title;
    private String content;
    private User from;
    private User to;


    public Message(long id,String title, String content, User from, User to) {
        super();
        this.id=id;
        this.title = title;
        this.content = content;
        this.from = from;
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public User getFrom() {
        return from;
    }
    public void setFrom(User from) {
        this.from = from;
    }
    public User getTo() {
        return to;
    }
    public void setTo(User to) {
        this.to = to;
    }

}
