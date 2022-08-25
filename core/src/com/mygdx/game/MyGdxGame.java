package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture birdTexture;

    Player player;

    // offset from the left side of the screen
    float PLAYER_OFFSET = 0.2f;

    private Obstacle obstacle;
    private Texture obstacleTexture;

    @Override
    public void create() {
        batch = new SpriteBatch();

        birdTexture = new Texture("red_bird.png");

        obstacleTexture = new Texture("pipe.png");
        Sprite obstacleSprite = new Sprite(obstacleTexture);

        obstacle = new Obstacle(obstacleSprite);
        obstacle.position = new Vector2(Gdx.graphics.getWidth()/2.0f, Gdx.graphics.getHeight()/2f);

        player = new Player(birdTexture);
        player.position = new Vector2(Gdx.graphics.getWidth() * PLAYER_OFFSET, Gdx.graphics.getHeight()/2.0f);
    }


    @Override
    public void render() {
        ScreenUtils.clear(.3f, .1f, .2f, 1);
        batch.begin();

        obstacle.Draw(batch);

        if (!player.isDead) {
            player.Draw(batch);
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        birdTexture.dispose();
    }
}
