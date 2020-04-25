package com.yeno.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State{
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    //protected 6 min 46s
    protected GameStateManager gm;

    public State(GameStateManager gm){
        this.gm = gm;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
