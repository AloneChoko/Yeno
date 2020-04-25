package com.yeno.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class ThisIsSpikes {
    private Vector3 position;


    private Texture spikes;

    public ThisIsSpikes(int x, int y) {
            position = new Vector3(x, y, 0);
            spikes = new Texture("Spikes.png");
    }

    public Vector3 getPosition() {
        return position;
    }


    public Texture getSpikes() {
        return spikes;
    }

    public void update(float dt){
    }

    public static void dispose(){
        ThisIsSpikes.dispose();
    }
}
