package br.com.caelum.forum.model;

public class Post {

    private String title;
    private String summary;

    public Post(String title, String summary) {
        this.title = title;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }
}
