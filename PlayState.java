package com.yeno.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.yeno.MainGame;
import com.yeno.sprites.ThisIsGround;
import com.yeno.sprites.ThisIsSpikes;
import com.yeno.sprites.Yeno;

public class PlayState extends State {


    private Vector3 position;

    //private Texture BackG;
    private ThisIsGround ground;
    private Yeno Spritee;
    //private Yeno Spritee1;
    private ThisIsSpikes spikes;

    public PlayState(GameStateManager gm) {
        super(gm);
        //BackG = new Texture("");
        Spritee = new Yeno(0, 0);
       // Spritee1 = new Yeno(0,0); изменить координаты
        camera.setToOrtho(false, MainGame.WIDTH, MainGame.HEIGHT);
        spikes = new ThisIsSpikes(400, 0);
        ground = new ThisIsGround(0,0);
    }




    @Override
    protected void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){ //временная мера, пока не запукается эмулятор и поблизости нет рабочего телефона, Gdx.justTouched() а вообще нужно приписать управление на телефоне в виде джойстика
            Spritee.jump();
            //Spritee1.jump();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            Spritee.goRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            //Spritee1.goLeft();
            Spritee.goLeft();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        Spritee.update(dt);
       // Spritee1.update(dt);
        spikes.update(dt);
        ground.update(dt);
        /*camera.position.x = Spritee.getPosition().x;
        camera.position.y = Spritee.getPosition().y; //перемещение камеры вслед за персонажем
        camera.update();    //код не доработан и глючит, стоит вернуться позже*/
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        //sb.draw(BackG, camera.position.x - (camera.viewportHeight / 2), 0) // фиксация бекграунда на одной точке (визуально), может не сработать
        sb.draw(ground.getGround(), ground.getPosition().x, ground.getPosition().y, ground.getGround().getWidth(), 64);
        sb.draw(spikes.getSpikes(), spikes.getPosition().x, spikes.getPosition().y+64);
        sb.draw(Spritee.getYeno(), Spritee.getPosition().x, Spritee.getPosition().y /*+50 ~ позиция земли*/ ); //не забыть поменять изначальный размер спрайта, лучше подогнать изображение под кратное 2
        //sb.draw(Spritee1.getYeno(), Spritee1.getPosition().x, Spritee1.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        //BackG.dispose();
        ThisIsSpikes.dispose();
        Yeno.dispose();
        ThisIsGround.dispose();
    }
}
