package com.yeno.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Yeno {

   /* public Fixture yenoPhysicsFixture;
    public Fixture yenoSensorFixture;
    Body box;    части для Box2D*/


    public static final int GRAVITY = -30;
    private Vector3 position;
    private Vector3 velosity;
    private Animation yenoAnimation;
    private Animation yenoAnimation1;
    private Rectangle bounds;
    private Texture Spritee;
   // private Texture Spritee1;//переделать в спрайт

    public Yeno (int x, int y){
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);
       // Spritee1 = new Texture("YenoAtlas1.png");
        Spritee = new Texture("YenoAtlas.png");
       // yeno = new TextureRegion();// условно, потому что этот метод для выбора части текстуры атласа
        //yenoAnimation1 = new Animation(new TextureRegion(Spritee1), 2,1/2f);
        yenoAnimation = new Animation(new TextureRegion(Spritee), 2, 1/3f);
        bounds = new Rectangle(x, y, Spritee.getWidth() /2, Spritee.getHeight());
       // bounds = new Rectangle(x, y, Spritee1.getWidth() /2, Spritee1.getHeight());
    }


    public Vector3 getPosition() {
        return position;
    }

    //public Sprite getYeno() { // убрать всю строку после добавления анимации, замена внизу
     //   return yeno;
    //}
    public TextureRegion getYeno() {
        return yenoAnimation.getFrame();
    }



    public void update(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            yenoAnimation.update(dt);
        } else {
        }
       /* if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            yenoAnimation1.update(dt);
        }else{
        }*/

        if(position.y>0)
            velosity.add(0, GRAVITY, 0);
            velosity.scl(dt);
            position.add(0, velosity.y, 0); //если вместо velosity.y установить значение 0, то спрайт стоит на месте

        if(position.y<0)
            position.y = 0;


        velosity.scl(1 / dt);

        if(position.x>0){
            velosity.add(0,-1/2,0);
            velosity.scl(dt);
            position.add(0, 0, 0);

            if(position.x<0)
                position.x = 0;

            velosity.scl(1 / dt);
            bounds.setPosition(position.x, position.y);

           /* if(checkCollisions()){
                System.out.println("Go");
            } это нужно для проверки столконовения с шипами по пикселям*/

        }
    }

    public boolean checkCollisions(){
        if(position.x >= 400){
            return true;
        }
        return false;
    }

    public void jump(){
        velosity.y = 600; /*скорость прыжка нормальная, скорость падения тоже, нужно изменить само ограничение прыжка
        работает кривовато, поискать, как поправить (здесь НЕЛЬЗЯ ставить ограниченые высоты, иначе енот не сможет прыгать на платформы выше,
             нужно придумать, как прописать именно высоту прыжка)*/
        if(position.y>0){
            velosity.y = -300; //персонаж опускается вниз, если на кнопку слишком часто нажимать
        }
    }
    public void goRight() {
        velosity.x = 30;
        if (velosity.x>0){
            position.x += 10;
            velosity.x = 0;
        /*}else {
            velosity.x = 30; */
        }
    }
    public void goLeft(){
        velosity.x = 0;
        if(position.x>=0){
            position.x -= 10;

        }
    }

    public static void dispose() {
        Yeno.dispose(); //yeno.dispose();
    }
}
