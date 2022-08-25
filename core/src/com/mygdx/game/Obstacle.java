package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacle {
    private Sprite bottomSprite;
    private Sprite topSprite;

    float moveSpeed = 700f;

    public Vector2 position;
    public float windowHeight = 750f;
    public Vector2 velocity;

    public Obstacle(Sprite _sprite) {
        position = Vector2.Zero;
        bottomSprite = new Sprite(_sprite);
        bottomSprite.setScale(10);

        topSprite = new Sprite(_sprite);
        topSprite.setScale(10);
        topSprite.setRotation(180);

        velocity = new Vector2(0, 0);
    }

    public void Update(float deltaTime) {
        position.x -= moveSpeed * deltaTime;

        if (position.x < 0 - bottomSprite.getWidth() * bottomSprite.getScaleX() / 2) {
            Reset();
        }
    }

    public void Draw(SpriteBatch spriteBatch) {
        Update(Gdx.graphics.getDeltaTime());
        bottomSprite.setPosition(position.x - bottomSprite.getWidth() / 2, position.y - windowHeight / 2 - bottomSprite.getHeight() * bottomSprite.getScaleY() / 2);
        bottomSprite.draw(spriteBatch);

        topSprite.setPosition(position.x - bottomSprite.getWidth() / 2, position.y + windowHeight / 2 + topSprite.getHeight() * topSprite.getScaleY() / 2);
        topSprite.draw(spriteBatch);
    }

    public void Reset() {
        position.x = Gdx.graphics.getWidth() + bottomSprite.getWidth() * bottomSprite.getScaleX() / 2;
        position.y = (float) RandomRange(Math.round(Gdx.graphics.getHeight()/4f), Gdx.graphics.getHeight() - Math.round(Gdx.graphics.getHeight()/4f));
//    position.y = Gdx.graphics.getHeight()/4f;
    }

    private float RandomRange(int a, int b){
        Random random = new Random();
        return a + random.nextInt(b - a);
    }
}
