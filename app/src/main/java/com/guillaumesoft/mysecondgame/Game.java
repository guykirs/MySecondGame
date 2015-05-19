package com.guillaumesoft.mysecondgame;

import android.content.Context;
import android.graphics.Point;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.impl.GLGame;
import tv.ouya.console.api.OuyaController;


public class Game extends GLGame
{
    /////////////////////////////////////////////////////////////////////////
    // CLASS VARAIBLES
    boolean firstTimeCreate = true;

    // CLASS FUNCTION
    @Override
    public Screen getStartScreen()
    {
        return new GamePanel(this);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        super.onSurfaceCreated(gl, config);

        if(firstTimeCreate)
        {
            Settings.load(getFileIO());
            Assets.load(this);
            //ScreenManager.game = this;
            firstTimeCreate = false;



            // CREATE A STATIC CONTEXT FOR THE GAME
            //ScreenManager.context = this;

            //WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
            //ScreenManager.display = wm.getDefaultDisplay();

           // ScreenManager.size = new Point();
           // ScreenManager.display.getSize(ScreenManager.size);

            // Point size = new Point();
            // display.getSize(size);

            // ScreenManager.WORLD_WIDTH = size.x;
            // ScreenManager.WORLD_HEIGHT = size.y;
        }
        else
        {
            Assets.reload();
        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        return OuyaController.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        return OuyaController.onKeyUp(keyCode, event) || super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onGenericMotionEvent( MotionEvent event)
    {

        return OuyaController.onGenericMotionEvent(event) || super.onGenericMotionEvent(event);
    }

    @Override
    public void onPause()
    {
        super.onPause();

    }

    @Override
    public void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}