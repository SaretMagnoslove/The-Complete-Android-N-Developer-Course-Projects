package com.saretmagnoslove.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {

	SpriteBatch batch;
	Texture background;

	Texture[] birds;
	int flapState = 0;
	float birdY = 0;
	float velocity = 0;

	int gameState;
	float gravity = 1;

	Texture topTube;
	Texture bottomTube;
	float gap = 400;
	float maxTubeOffset;
	Random randomGenerator;
	float tubeVelocity = 4;
	int numberOfTubes = 4;
	float[] tubeX = new float[numberOfTubes];
	float[] tubeOffset = new float[numberOfTubes];
	float distanceBetweenTubes;

	@Override
	public void create () {

		batch = new SpriteBatch();
		background = new Texture("bg.png");

		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight()/2-birds[0].getHeight()/2;

		topTube = new Texture("toptube.jpeg");
		bottomTube = new Texture("bottomtube.jpeg");
		maxTubeOffset = Gdx.graphics.getHeight()/2 - gap/2 - 100;
		randomGenerator = new Random();
		distanceBetweenTubes = Gdx.graphics.getWidth() *3/4;

		for (int ii=0; ii<numberOfTubes; ii++) {

			tubeOffset[ii] = (randomGenerator.nextFloat() - 0.5f)  * (Gdx.graphics.getHeight() - gap - 200);

			tubeX[ii] = Gdx.graphics.getWidth()/2 - topTube.getWidth()/2 + ii*distanceBetweenTubes;
		}
	}

	@Override
	public void render () {

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (gameState != 0) {

			if (Gdx.input.justTouched()) {

				velocity = -20;
			}

			for (int ii=0; ii<numberOfTubes; ii++) {

			    if (tubeX[ii] < -topTube.getWidth()) {

			        tubeX[ii] += numberOfTubes * distanceBetweenTubes;
                }else {

                    tubeX[ii] -= tubeVelocity;
                }

				batch.draw(topTube, tubeX[ii], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[ii]);
				batch.draw(bottomTube, tubeX[ii], Gdx.graphics.getHeight() / 2 - gap / 2 - bottomTube.getHeight() + tubeOffset[ii]);
			}

            if (birdY > 0 || velocity < 0) {

                velocity += gravity;
                birdY -= velocity;
            }

        }else {

            if (Gdx.input.justTouched()) {

                gameState = 1;
            }
        }

        if (flapState == 0) {
            flapState = 1;
        } else {
            flapState = 0;
        }

        batch.draw(birds[flapState], Gdx.graphics.getWidth() / 2 - birds[flapState].getWidth() / 2
                , birdY);
        batch.end();
	}
}
