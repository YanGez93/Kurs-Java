package com.feed.demo;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonActions {

    static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    static File jsonFile = new File("src/main/resources/static/data.json");
    
    public static Post[] addPost(String title, String content) throws IOException
    {
        Post[] oldPosts = objectMapper.readValue(new File("src/main/resources/static/data.json"), Post[].class);
        Post[] newPosts = new Post[oldPosts.length + 1];
        int maxVal = 0;

        

        for(int i= 0;i<oldPosts.length ;i++)
        { 
            maxVal = Math.max(oldPosts[i].id, maxVal); 

            newPosts[i]=oldPosts[i];
        }
        
        int newId = maxVal+1;

        newPosts[oldPosts.length] = new Post(newId, title, content);

        objectMapper.writeValue(jsonFile, newPosts);
        return newPosts;
    }
    
    public static Post getPost(int id) throws IOException
    {
        Post[] posts = objectMapper.readValue(jsonFile, Post[].class);
        Post result;

        for(int i= 0;i<posts.length ;i++)
        { 
           if(posts[i].id==id)
           {
                result = posts[i];
                return result;
           }
        }
        result = new Post(0,"404","Post not found");
        return result;
    }

  
    public static Post[] delPost(int id) throws IOException
    {
        Post[] oldPosts = objectMapper.readValue(jsonFile, Post[].class);

        Post[] newPosts = new Post[oldPosts.length-1];

        int i=0;
        for(Post o: oldPosts)
        {
            if(o.id!=id)
            {
                newPosts[i] = o;
                i++;
            }

        }

    
        objectMapper.writeValue(jsonFile, newPosts);
        return newPosts;
    }

    public static Post[] loadPosts() throws IOException
    {
        Post[] posts = objectMapper.readValue(jsonFile, Post[].class);
    
        return posts;
    }

}
