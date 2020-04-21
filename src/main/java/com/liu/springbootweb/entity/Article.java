package com.liu.springbootweb.entity;

import io.searchbox.annotations.JestId;

/**
 * @ClassName: Article
 * @Description: 文章类
 * @Author: 52945
 * @Date: 2019/11/9 19:56
 * @Version: 1.0
 */
public class Article {

    @JestId
    private Integer id;
    private String title;
    private String author;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article() {
    }

    public Article(Integer id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

}
