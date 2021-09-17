package com.gierka.beta;

import java.util.Date;

public class Game {

    long time;
    int fps;

    public Game()
    {
        this.time = new Date().getTime();
        this.fps = 10;

    }

    public void update()
    {
        this.time = new Date().getTime();
    }
    
}
