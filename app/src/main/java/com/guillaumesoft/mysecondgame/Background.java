package com.guillaumesoft.mysecondgame;

import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;


/**
 * Created by guyki on 5/19/2015.
 */
public class Background
{
    private int x, y, dx;

    public Background()
    {

    }

    public void Update()
    {
        x+=dx;

        if(x<-GamePanel.WIDTH)
        {
            x=0;
        }
    }

    public void Draw(SpriteBatcher batcher,Camera2D Cam )
    {
        // SHOW THE RATING SCREEN
        batcher.drawSprite(x , Cam.frustumHeight /2, 1920, 1080, Assets.backgroundRegion);

        if(x<0)
        {
            batcher.drawSprite(x + GamePanel.WIDTH, Cam.frustumHeight / 2, 1920, 1080, Assets.backgroundRegion);
        }
    }

    public void setVector(int dx)
    {
        this.dx = dx;
    }
}
