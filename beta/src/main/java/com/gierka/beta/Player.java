package com.gierka.beta;
public class Player {

    String name;
    int x,y;

    public Player(String playerName)
    {
        this.name=playerName;
        this.x = 0;
        this.y = 0;
    }


    public String getValues(String controls,String playerName)
    {

        if(playerName.contains(this.name))
        {
            switch(controls)
            {
                case "87":
                    this.y-=1f;
                    break;
                case "83":
                    this.y+=1f;
                    break;
                case "65": 
                    this.x-=1f;       
                    break;
                case "68":  
                    this.x+=1f;
                    break;
    
            }
        }
        

        
        String result =    "{";
        result += "      \"name\": \""+this.name+"\",";
        result += "      \"cyle\": \"0\",";
        result += "      \"console\": \"Threre's no room.\",";
        result += "      \"frameNo\": \"1135\",";
        result += "      \"direction\": \"2\",";
        result += "      \"sprite\": \"citizen\",";
        result += "      \"speed\": \"2.0\",";
        result += "      \"pEF\": \"0\",";
        result += "      \"position\": [ "+this.x+","+this.y+", 0.0]";
        result += "    }";

        return result;



    }
}
