package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Moon extends Body {


    public Moon(Texture BodyTexture, int WIDTH, int HEIGHT){
        ObjectBody = BodyTexture;
        Width = WIDTH;
        Height = HEIGHT;
    }
}
