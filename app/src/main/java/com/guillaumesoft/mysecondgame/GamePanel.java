package com.guillaumesoft.mysecondgame;

import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLScreen;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by guyki on 5/18/2015.
 */
public class GamePanel extends GLScreen
{
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;

    private Camera2D guiCam;
    private SpriteBatcher batcher;
    //private MainThread thread;
    private Background bg;

    public GamePanel(Game game)
    {
        super(game);

        // SET THE CAMERA
        guiCam   = new Camera2D(glGraphics, 1920, 1080);
        batcher  = new SpriteBatcher(glGraphics, 100);

        bg = new Background();
        bg.setVector(-5);
    }

    @Override
    public void update(float deltaTime)
    {
        bg.Update();
    }

    @Override
    public void present(float deltaTime)
    {
        int scaleFactorX = 1920 / 512;
        int scaleFactorY = 1080 / 512;

        GL10 gl = glGraphics.getGL();
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        guiCam.setViewportAndMatrices();

        gl.glScalef(scaleFactorX, scaleFactorY, 1.0f);

        gl.glEnable(GL10.GL_TEXTURE_2D);

           batcher.beginBatch(Assets.background);

              bg.Draw(batcher, guiCam);

           batcher.endBatch();

        gl.glDisable(GL10.GL_BLEND);

    }

    @Override
    public void pause() {   }

    @Override
    public void resume() {  }

    @Override
    public void dispose()  {  }
}
