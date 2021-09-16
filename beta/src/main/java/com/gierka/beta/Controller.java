package com.gierka.beta;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    ArrayList<Player> creatures = new ArrayList<Player>();

    @GetMapping("/playerPosition")
    public String getInfo(String playerName,String controls)
    {
        System.out.println(controls);
        
        //Make player or get him
        boolean isPlayer = false;
        Player thisPlayer;

        for(Player p: creatures)
        {
            if(p.name.equals(playerName) ) 
            {
                thisPlayer=p;
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
            result+= p.getValues(controls,playerName);
            i++;
        }
        
        result += "  ]";
        result += "}";

        return result;
    }
}
