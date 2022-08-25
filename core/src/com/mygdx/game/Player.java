package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Sprite sprite;
    public float jumpVelocity = 25f;

    Vector2 velocity;
//    float jumpCooldown = 0.3f;
    float gravity = 60f;
    float maxVelocity = 20f;
    boolean isDead = false;

    public Player(Texture texture) {
        sprite = new Sprite(texture);
        position = Vector2.Zero;
        velocity = Vector2.Zero;
        sprite.setScale(.3f);
    }

    void Update(float deltaTime) {

        if (Gdx.input.isTouched()) {
            velocity.y = jumpVelocity;
        }

        // if player touched the bottom of the screen
        if(position.y < 0 + sprite.getHeight() * sprite.getScaleY() / 2){
            Die();
        }

        if(velocity.y > -maxVelocity){
            velocity.y -= gravity * deltaTime;
        }
        position.x += velocity.x;
        position.y += velocity.y;
    }

    void Die(){
        isDead = true;
        System.out.println("DEBUG: GAME OVER");
    }

    public void Draw(SpriteBatch spriteBatch) {
        if(!isDead){
            Update(Gdx.graphics.getDeltaTime());
        }

        sprite.setPosition(position.x - sprite.getWidth()/2, position.y - sprite.getHeight()/2);
        sprite.draw(spriteBatch);
    }

}
