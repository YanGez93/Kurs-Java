package com.gierka.beta;
public class Grid {
    String value;
    

    /*
    public Grid(String grid)
    {
        this.value = grid;
    }
    */

    int texture,x,y,z,tx,ty,tz;
    int newX,newY,newZ;

    public void makeGrid(
        int texture,
        int x,
        int y,
        int z
    )
    {
        this.texture = texture;
        this.x=x;
        this.y=y;
        this.z=z;

    }

    public void makeGrid(
        int texture,
        int x,
        int y,
        int z,
        int newX,
        int newY,
        int newZ
    )
    {
        this.texture = texture;
        this.x=x;
        this.y=y;
        this.z=z;

        this.newX=newX;
        this.newY=newY;
        this.newZ =newZ;

    }
}
