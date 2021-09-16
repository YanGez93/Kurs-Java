package com.feed.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    public int id;
    public String title;
    public String content;

    public Post(@JsonProperty("id") int id,@JsonProperty("title")String title,@JsonProperty("content")String content){
      this.id = id;
      this.title = title;
      this.content =content;
    }
}
