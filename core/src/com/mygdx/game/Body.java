package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Body {

    public Texture ObjectBody;
    public int Width,Height,ObjectPosX,ObjectPosY;

    private int PosX(int ParentX, float R, double Time){
        int x1;
        x1 =(int) (ParentX + R * Math.cos(Time));
        return x1;
    }

    private int PosY(int ParentY, float R, double Time){
        int y1;
        y1 = (int) (ParentY + R * Math.sin(Time));
        return y1;
    }
    public void getPos(int ParentX, int ParentY, int R, double Time){
        ObjectPosX = PosX(ParentX,R, Time) + Width/2;
        ObjectPosY = PosY(ParentY,R, Time) + Height/2;
    }


}
