package com.gierka.beta;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

    
       
    }


    public void load()throws JsonParseException, JsonMappingException, IOException
    {
        String str = new String(Files.readAllBytes(jsonFile.toPath()));

        str = str.replaceAll("(\\r|\\n)", "");
        str = str.replaceAll(" ", "");
        str = str.replaceAll("\\\"", "");
        str = str.replaceAll( "\\[\\[","");
        str = str.replaceAll("\\]\\]","");

        
        String[] strTable=str.split("],\\[");

        ArrayList<Grid> grids = new ArrayList<Grid>();   
        

        for(int i=0;i<strTable.length;i++)
        {
            Grid gridToAdd = new Grid();
            if(strTable[i].length()==4)
            {
                gridToAdd.makeGrid(Integer.parseInt(strTable[i]),Integer.parseInt(strTable[i]),Integer.parseInt(strTable[i]),Integer.parseInt(strTable[i]));
                grids.add(gridToAdd);
            }
            else if(strTable[i].length()==7)
            {

            }
            

        }
       
       // grids.add(e);

        System.err.println(str);
    }
}
