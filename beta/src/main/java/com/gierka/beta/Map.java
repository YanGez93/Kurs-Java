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
            String[] singleField = strTable[i].split(",");
          //  System.out.println(strTable[i]);

            
            if(strTable[i].length()==8)
            {
                
                gridToAdd.makeGrid(Integer.parseInt(singleField[0]),Integer.parseInt(singleField[1]),Integer.parseInt(singleField[2]),Integer.parseInt(singleField[3]));
                grids.add(gridToAdd);
                System.out.println(gridToAdd.texture+gridToAdd.x+gridToAdd.y+gridToAdd.z);
                System.out.println(strTable[i]);
            }
            else if(strTable[i].length()==15)
            {
                
                gridToAdd.makeGrid(Integer.parseInt(singleField[0]),Integer.parseInt(singleField[1]),Integer.parseInt(singleField[2]),Integer.parseInt(singleField[3]));
                grids.add(gridToAdd);
                System.out.println(gridToAdd.texture+gridToAdd.x+gridToAdd.y+gridToAdd.z);
                System.out.println(strTable[i]);
            }

            /*
            if(strTable[i].length()==9)
            {
                
                
                gridToAdd.makeGrid(Integer.parseInt(strTable2[0]),Integer.parseInt(strTable2[1]),Integer.parseInt(strTable2[2]),Integer.parseInt(strTable2[3]));
                grids.add(gridToAdd);
                System.err.println(gridToAdd.texture+gridToAdd.x+gridToAdd.y+gridToAdd.z);
            }
            else if(strTable[i].length()==7)
            {

            }   

            */

        }
       
       // grids.add(e);

        //System.err.println(str);
    }
}