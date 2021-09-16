package com.gierka.beta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    float x =0f;
    float y= 0f;

    

    @GetMapping("/playerPosition")
    public String getInfo(String playerName,String controls)
    {
        System.out.println(controls);
        
       // Player player = new Player();

       

        switch(controls)
        {
            case "87":
                y-=1f;
                break;
            case "83":
                y+=1f;
                break;
            case "65": 
                x-=1f;       
                break;
            case "68":  
                x+=1f;
                break;

        }

        String result = "{";
        result += "\"fps\": 15,";
        result += "\"frameNo\": 1270,";
        result += "  \"players\": [";
        result += "    {";
        result += "      \"name\": \""+playerName+"\",";
        result += "      \"cyle\": \"0\",";
        result += "      \"console\": \"Threre's no room.\",";
        result += "      \"frameNo\": \"1135\",";
        result += "      \"direction\": \"2\",";
        result += "      \"sprite\": \"citizen\",";
        result += "      \"speed\": \"2.0\",";
        result += "      \"pEF\": \"0\",";
        result += "      \"position\": [ "+x+","+y+", 0.0]";
        result += "    }";
        result += "  ]";
        result += "}";

        return result;
    }
}
