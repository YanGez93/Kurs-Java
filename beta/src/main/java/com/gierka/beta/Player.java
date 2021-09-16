package com.gierka.beta;
public class Player {

    String name;
    int x,y,direction,cyle;

    public Player(String playerName)
    {
        this.name=playerName;
        this.x = 0;
        this.y = 0;
        this.direction=0;

    }

    public void update(String controls)
    {
        if(controls!="")
        {
            if(this.cyle==0 || this.cyle==1)
            {
                this.cyle++;
            }
            if(this.cyle==2)
            {
                this.cyle=1;
            }
            else
            {
                this.cyle=0;
            }
            
        }
        else
        {
            this.cyle=0;
        }

        switch(controls)
        {
            case "87":
                this.y-=1f;
                this.direction=0;
                break;
            case "83":
                this.y+=1f;
                this.direction=1;
                break;
            case "65": 
                this.x-=1f;
                this.direction=3;       
                break;
            case "68":  
                this.x+=1f;
                this.direction=2;
                break;
            default:
                break;

        }
    
    }

    public String getValues()
    {
        
        String result =    "{";
        result += "      \"name\": \""+this.name+"\",";
        result += "      \"cyle\": \""+this.cyle+"\",";
        result += "      \"console\": \"Threre's no room.\",";
        result += "      \"frameNo\": \"1135\",";
        result += "      \"direction\": \""+this.direction+"\",";
        result += "      \"sprite\": \"citizen\",";
        result += "      \"speed\": \"2.0\",";
        result += "      \"pEF\": \"0\",";
        result += "      \"position\": [ "+this.x+","+this.y+", 0.0]";
        result += "    }";

        return result;



    }
}
