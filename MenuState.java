package com.yeno.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yeno.MainGame;


public class MenuState extends State {

    private Texture background;
    //private Texture playBtn;

    public MenuState(GameStateManager gm) {
        super(gm);
        camera.setToOrtho(false, MainGame.WIDTH, MainGame.HEIGHT);  // /2
        background = new Texture("background1.png");
       // playBtn = new Texture("");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gm.set(new PlayState(gm));
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0, 0, MainGame.WIDTH, MainGame.HEIGHT);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
