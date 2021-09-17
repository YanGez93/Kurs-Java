package com.gierka.beta;

import ch.qos.logback.core.joran.conditional.ElseAction;

public class Player {

    String name;
    int x,y,direction,cyle;

    Map map = new Map();

    public Player(String playerName)
    {
        this.name=playerName;
        this.x = 0;
        this.y = 0;
        this.direction=0;
        this.cyle=0;

    }

    public void update(String controls)
    {
        if(controls!="")
        {
            if(this.cyle==0 || this.cyle==1)
            {
                this.cyle++;
            }
            else if(this.cyle==2)
            {
                this.cyle=1;
            }
            
            
        }
        else
        {
            this.cyle=0;
        }

        int x = this.x;
        int y = this.y;

        switch(controls)
        {
            case "87":
                y-=1;
                this.direction=0;
                break;
            case "83":
                y+=1;
                this.direction=1;
                break;
            case "65": 
                x-=1;
                this.direction=3;       
                break;
            case "68":  
                x+=1;
                this.direction=2;
                break;
            default:
                break;
        }


        boolean canMove=true;


        String checkValue = map.checkGrids(x, y, 0, null, 0, 0, 0);

        if(checkValue=="Pole istnieje")
        {
            canMove=true;
        }
        else if(checkValue=="stairs")
        {
            canMove=false;
        }
        

        if(canMove)
        {
            this.x=x;
            this.y=y;

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
