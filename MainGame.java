package com.yeno;

import com.badlogic.gdx.ApplicationAdapter;
import java.util.Scanner;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yeno.states.GameStateManager;
import com.yeno.states.MenuState;

public class MainGame extends Game {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;
    Scanner sc = new Scanner(System.in);

    public static final String TITLE = "Yeno";

    private GameStateManager gm;
	private SpriteBatch batch;
	/*Texture Sprite1;
	private Sound sound;
	private Music music; */
	@Override
	public void create () {

		//Sprite1 = new Texture("Sprite1.png");

		batch = new SpriteBatch();
		gm = new GameStateManager();
		//music = Gdx.audio.newMusic(Gdx.files.internal(""));
		Gdx.gl.glClearColor(0, 0, 1, 0);
		gm.push(new MenuState(gm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gm.update(Gdx.graphics.getDeltaTime());
		gm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//Sprite1.dispose(); //то бишь очищать нужно всё
	}
}
