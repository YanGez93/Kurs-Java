package com.gierka.beta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Map {

    static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    static File jsonFile = new File("src/main/resources/static/json/map.json");

    public Map() 
    {

       ArrayList<Grid> grids = new ArrayList<Grid>();   

       
    }


    public void load()throws JsonParseException, JsonMappingException, IOException
    {
        
        Grid grid = objectMapper.readValue(jsonFile, Grid.class);
        System.err.println(grid);
    }
}
