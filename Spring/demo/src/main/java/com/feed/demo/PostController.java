package com.feed.demo;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
  @GetMapping("/hello")
  public String Hello(){
    return "Hello world";
  }

  /*
  @GetMapping("/addPost")
  public String AddPost(String title, String content){

    return title+" / "+content;

  }

  */

  @GetMapping("/addPost")
  public com.feed.demo.Post[] AddPost(String title, String content) throws IOException 
  {
      return JsonActions.addPost(title,content);
  }
  
  @GetMapping("/getPost")
  public com.feed.demo.Post GetPost(int id) throws IOException 
  {
      return JsonActions.getPost(id);
  }

  @GetMapping("/delPost")
  public com.feed.demo.Post[] DelPost(int id) throws IOException 
  {
      return JsonActions.delPost(id);
  }


}