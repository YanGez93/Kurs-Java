package com.gierka.beta;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;



public class Map {

    static File jsonFile = new File("src/main/resources/static/json/map.json");
    private ArrayList<Grid> grids;

    public Map()
    {

        try {
            this.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }

    public void load()throws IOException
    {
        String str = new String(Files.readAllBytes(jsonFile.toPath()));

        str = str.replaceAll("(\\r|\\n)", "");
        str = str.replaceAll(" ", "");
        str = str.replaceAll("\\\"", "");
        str = str.replaceAll( "\\[\\[","");
        str = str.replaceAll("\\]\\]","");

        String[] strTable=str.split("],\\[");

        this.grids = new ArrayList<Grid>();   
        

        for(int i=0;i<strTable.length;i++)
        {
            Grid gridToAdd = new Grid();
            String[] singleField = strTable[i].split(",");
  
            
            if(singleField.length==4)
            {
                gridToAdd.makeGrid(Integer.parseInt(singleField[0]),Integer.parseInt(singleField[1]),Integer.parseInt(singleField[2]),Integer.parseInt(singleField[3]));
                //System.out.println("Grid zwykły");
            }
            else
            {
                gridToAdd.makeGrid(Integer.parseInt(singleField[0]),Integer.parseInt(singleField[1]),
                Integer.parseInt(singleField[2]),Integer.parseInt(singleField[3]),
                Integer.parseInt(singleField[5]),Integer.parseInt(singleField[6]),
                Integer.parseInt(singleField[7]));

                //System.out.println("Grid stairs");

            }
            grids.add(gridToAdd);

         
            //System.out.println(strTable[i]);
            

        }
   
    }

    public String checkGrids(int x,int y,int z,String nazwaPola,int newX,int newY, int newZ)
    {

        for(Grid g: grids)
        {
            if(g.x ==x && g.y==y && g.z==z)
            {
                
                System.out.println("Pole istnieje");
                return "true";
            }
            else if(nazwaPola=="stairs")
            {
                System.out.println("Jest to pole Stairs");

                return newX+","+newY+","+newZ;
            }
            else
            {
                System.out.println("Pole nie istnieje, jest to pole black a wartośc tego pola to "+ x+" " +y+" "+z);
                return null;
            }
        }
        return null;
    }


}
