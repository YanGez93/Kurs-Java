package com.gierka.beta;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Map map = new Map();
    
    ArrayList<Player> creatures = new ArrayList<Player>();

    @GetMapping("/playerPosition")
    public String getInfo(String playerName,String controls) throws JsonParseException, JsonMappingException, IOException
    {
        System.out.println(controls);
        
        map.load();

        
        //Make player or get him
        boolean isPlayer = false;
        Player thisPlayer ;//= new Player(playerName);

        for(Player p: creatures)
        {
            if(p.name.equals(playerName) ) 
            {
                thisPlayer=p;
                thisPlayer.update(controls);
                isPlayer=true;
            }  
        }

        
        if(!isPlayer)
        {
            thisPlayer = new Player(playerName);
            creatures.add(thisPlayer);
        }
        
        
        
        

        String result = "{";
        result += "\"fps\": 15,";
        result += "\"frameNo\": 1270,";
        result += "  \"players\": [";
        
        int i =0;
        for(Player p: creatures)
        {
            if(i!=0)
            {
                result+=",";
            }
            result+= p.getValues();
            i++;
        }
        
        result += "  ]";
        result += "}";

        return result;
    }
}
