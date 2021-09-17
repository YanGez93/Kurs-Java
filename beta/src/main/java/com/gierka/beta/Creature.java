package com.gierka.beta;

import java.util.ArrayList;

public class Creature {

    String name,type,sprite,console;
    int x,y,z,direction,cyle;

    float speed;
    long walkExhaust;

    Game game = new Game();
    Map map = new Map();

    public Creature(String playerName, String type)
    {
        this.name=playerName;
        this.x = 0;
        this.y = 0;
        this.z=0;
        this.direction=0;
        this.cyle=0;
        this.speed=5.4f;
        this.walkExhaust=0;
        this.type=type;
        this.sprite = "citizen";
        this.console = "";
    }

    public ArrayList<Creature> list()
    {
        ArrayList<Creature> list = new ArrayList<Creature>();
      
        Creature m1 = new Creature("Dragon1","monster");
        m1.x=15;
        m1.y=7;
        m1.z=1;
        m1.speed=1;
        m1.sprite = "black_dragon";
        list.add(m1);

        Creature m2 = new Creature("Amazon","monster");
        m2.x=9;
        m2.y=2;
        m2.z=0;
        m2.speed=10;
        m2.sprite = "female";
        list.add(m2);
        return list;
    }

    public void update(String controls)
    {
        game.update();

        if(controls!="" && this.walkExhaust<game.time)
        {
            if(this.cyle==0 || this.cyle==1)
            {
                this.cyle++;
            }
            else if(this.cyle==2)
            {
                this.cyle=1;
            }
            
            int x = this.x;
            int y = this.y;
            int z = this.z;

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


            String[] checkValue = map.checkGrids(x, y, z).split(",");

            if(checkValue[0].equals("floor"))
            {
                canMove=true;
            }
            else if(checkValue[0].equals("stairs"))
            {

                canMove=true;
                x=Integer.parseInt(checkValue[1]);
                y=Integer.parseInt(checkValue[2]);
                z=Integer.parseInt(checkValue[3]);
            }
            else
            {
                canMove=false;
            }

            if(canMove)
            {
                this.x=x;
                this.y=y;
                this.z=z;

                this.walkExhaust = game.time+(long)(1000/this.speed);
            }
            
        }
        else
        {
            this.cyle=0;
        }

        
        

       
    
    }

    public String getValues()
    {
        
        String result =    "{";
        result += "      \"name\": \""+this.name+"\",";
        result += "      \"cyle\": \""+this.cyle+"\",";
        result += "      \"console\": \""+this.console+"\",";
        result += "      \"frameNo\": \"1135\",";
        result += "      \"direction\": \""+this.direction+"\",";
        result += "      \"sprite\": \""+this.sprite+"\",";
        result += "      \"speed\": \""+this.speed+"\",";
        result += "      \"pEF\": \"0\",";
        result += "      \"position\": [ "+this.x+","+this.y+","+this.z+"]";
        result += "    }";

        return result;



    }
}
