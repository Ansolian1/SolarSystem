package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
//import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Sun sun;
	private Planet earth;
	private Planet jupiter;
	private Moon moon;

	private Texture Sun;
	private Texture Earth;
	private Texture Moon;
	private Texture Jupiter;
	private double EarthT, MoonT;
	private boolean isPause;
	private Stage stage;
	private TextButton button;
	private TextButton.TextButtonStyle style;

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		batch = new SpriteBatch();
		isPause = false;
        Sun = new Texture("sun.png");
		Earth = new Texture("earth.png");
		Moon = new Texture("moon.png");
		Jupiter = new Texture("Jupiter.png");

		sun = new Sun(Sun, 200, 200);
		earth = new Planet(Earth, 60,60);
		jupiter = new Planet(Jupiter, 70,70);
		moon = new Moon(Moon, 30,30);


		style = new TextButton.TextButtonStyle();

		//Skin mySkin = new Skin(Gdx.files.internal("D:\\test\\skin\\glassy-ui.json" ));
		style.font  =  new BitmapFont();
		style.fontColor = Color.GREEN;
		button = new TextButton("pause",style);
		button.setSize(200,150);
		button.setPosition(0,10);
		button.addListener(new InputListener(){
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				isPause = !isPause;
				return true;
			}
		});
		stage.addActor(button);
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(!isPause) {
			EarthT += 0.01;
			MoonT += 0.05;
		}
		earth.getPos(350,350,200,EarthT);
		moon.getPos(earth.ObjectPosX,earth.ObjectPosY,56,MoonT);
		jupiter.getPos(350,350,340,-EarthT);




		batch.begin();
		batch.draw(sun.ObjectBody,300 ,300, sun.Width, sun.Height);
        batch.draw(earth.ObjectBody,earth.ObjectPosX,earth.ObjectPosY, earth.Width, earth.Height);
        batch.draw(moon.ObjectBody, moon.ObjectPosX , moon.ObjectPosY ,moon.Width,moon.Height );
        batch.draw(jupiter.ObjectBody, jupiter.ObjectPosX, jupiter.ObjectPosY, jupiter.Width, jupiter.Height);
		batch.end();
		stage.draw();
	}



	@Override
	public void dispose () {
		batch.dispose();
		Sun.dispose();
		Earth.dispose();
		Moon.dispose();
		Jupiter.dispose();
	}
}
