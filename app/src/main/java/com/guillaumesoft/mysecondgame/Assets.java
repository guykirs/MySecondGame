package com.guillaumesoft.mysecondgame;

import com.badlogic.androidgames.framework.Music;
import com.badlogic.androidgames.framework.Sound;
import com.badlogic.androidgames.framework.gl.Animation;
import com.badlogic.androidgames.framework.gl.Font;
import com.badlogic.androidgames.framework.gl.Texture;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.impl.GLGame;

///  THIS CLASS SETS THE ASSETS FOR THE GAME
///  JUNE 23, 2014
///  GUILLAUME SWOLFS
///  GUILLAUMESOFT
public class Assets
{

    // GAME BACKGROUND
    public static Texture background;
    public static TextureRegion backgroundRegion;

    public static Texture RedFont;
    public static Font redfont;


    public static void load(GLGame game)
    {
        background           = new Texture(game, "grassbg1.png");
        backgroundRegion     = new TextureRegion(background, 0, 0, 512, 512);

        RedFont = new Texture(game, "redFont.png");
        redfont = new Font(RedFont, 224, 0, 16, 16, 20);
    }

    public static void reload()
    {
        background.reload();
        RedFont.reload();
    }


}
