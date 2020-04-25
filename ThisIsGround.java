package com.yeno.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class ThisIsGround {
    private Vector3 position;
    private Texture ground;

    public ThisIsGround(int x, int y){
        position = new Vector3(x, y, 0);
        ground = new Texture("Ground.png");
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getGround() {
        return ground;
    }

    public void update(float dt){
        //прописать создание нового спрайта земли, как только закончится длина старого
    }

    public static void dispose() {
        ThisIsGround.dispose(); //ground.dispose();
    }
}
