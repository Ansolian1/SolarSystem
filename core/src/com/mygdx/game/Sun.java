package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;


public class Sun extends Body {

    public Sun(Texture BodyTexture, int WIDTH, int HEIGHT){
        ObjectBody = BodyTexture;
        Width = WIDTH;
        Height = HEIGHT;
    }
}
