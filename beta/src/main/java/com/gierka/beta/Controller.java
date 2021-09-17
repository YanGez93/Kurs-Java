package com.gierka.beta;

import java.io.IOException;
import java.util.ArrayList;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.datatype.jsr310.deser.MonthDayDeserializer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {



    Map map = new Map();
    Game game = new Game();

    Creature cr = new Creature(null,null);

    ArrayList<Creature> crList = new ArrayList<Creature>();
    ArrayList<Creature> creature = cr.list();

    @GetMapping("/playerPosition")
    public String getInfo(String playerName,String controls) throws JsonParseException, JsonMappingException, IOException
    {

        
        //Make player or get him
        boolean isPlayer = false;
        Creature thisPlayer ;//= new Player(playerName);

        for(Creature p: crList)
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
            thisPlayer = new Creature(playerName,"player");
            crList.add(thisPlayer);
        }
        

        String result = "{";
        result += "\"fps\": \""+game.fps+"\",";
        result += "\"frameNo\": 1270,";
        result += "\"time\": \""+game.time+"\",";
        result += "  \"players\": [";
        
        int i =0;
        for(Creature p: crList)
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

    @GetMapping("/test")
    public int test()
    {
        String x="1,2,3,4";

        return x.length();
    }
}
