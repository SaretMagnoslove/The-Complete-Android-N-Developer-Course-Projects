package com.saretmagnoslove.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {

	SpriteBatch batch;
	Texture background;
	//ShapeRenderer shapeRenderer;

	Texture[] birds;
	int flapState = 0;
	float birdY = 0;
	float velocity = 0;
	Circle birdCircle;
	int score = 0;
	int scoringTube = 0;
	BitmapFont font;

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
    Rectangle[] topTubeRectangles;
    Rectangle[] bottomTubeRectangles;

	@Override
	public void create () {

		batch = new SpriteBatch();
		background = new Texture("bg.png");
		//shapeRenderer = new ShapeRenderer();
		birdCircle = new Circle();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(10);

		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight()/2-birds[0].getHeight()/2;

		topTube = new Texture("toptube.png");
		bottomTube = new Texture("bottomtube.png");
		maxTubeOffset = Gdx.graphics.getHeight()/2 - gap/2 - 100;
		randomGenerator = new Random();
		distanceBetweenTubes = Gdx.graphics.getWidth() *3/4;
		topTubeRectangles = new Rectangle[numberOfTubes];
		bottomTubeRectangles = new Rectangle[numberOfTubes];

		for (int ii=0; ii<numberOfTubes; ii++) {

			tubeOffset[ii] = (randomGenerator.nextFloat() - 0.5f)  * (Gdx.graphics.getHeight() - gap - 200);

			tubeX[ii] = Gdx.graphics.getWidth()/2 - topTube.getWidth()/2 + Gdx.graphics.getWidth() + ii*distanceBetweenTubes;

			topTubeRectangles[ii] = new Rectangle();
			bottomTubeRectangles[ii] = new Rectangle();
		}
	}

	@Override
	public void render () {

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (gameState != 0) {

            if (tubeX[scoringTube] < Gdx.graphics.getWidth() / 2) {

                score++;

                Gdx.app.log("score", String.valueOf(score));

                if (scoringTube < numberOfTubes - 1) {

                    scoringTube++;
                } else {

                    scoringTube = 0;
                }
            }

			if (Gdx.input.justTouched()) {

				velocity = -20;
			}

			for (int ii=0; ii<numberOfTubes; ii++) {

			    if (tubeX[ii] < -topTube.getWidth()) {

			        tubeX[ii] += numberOfTubes * distanceBetweenTubes;
                    tubeOffset[ii] = (randomGenerator.nextFloat() - 0.5f)  * (Gdx.graphics.getHeight() - gap - 200);
                }else {

                    tubeX[ii] -= tubeVelocity;

                }

				batch.draw(topTube, tubeX[ii], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[ii]);
				batch.draw(bottomTube, tubeX[ii], Gdx.graphics.getHeight() / 2 - gap / 2 - bottomTube.getHeight() + tubeOffset[ii]);

				topTubeRectangles[ii] = new Rectangle(tubeX[ii],Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[ii]
                    ,topTube.getWidth(), topTube.getHeight());
				bottomTubeRectangles[ii] = new Rectangle(tubeX[ii], Gdx.graphics.getHeight() / 2 - gap / 2 - bottomTube.getHeight() + tubeOffset[ii]
                    ,bottomTube.getWidth(),bottomTube.getHeight());

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

        font.draw(batch, String.valueOf(score),100,200);

        batch.end();

        birdCircle.set(Gdx.graphics.getWidth()/2
                ,birdY+birds[flapState].getHeight()/2,birds[flapState].getWidth()/2);

        //shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //shapeRenderer.setColor(Color.RED);
        //shapeRenderer.circle(birdCircle.x,birdCircle.y,birdCircle.radius);

        for (int ii=0; ii<numberOfTubes; ii++) {

            //shapeRenderer.rect(tubeX[ii], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[ii]
                    //, topTube.getWidth(), topTube.getHeight());
            //shapeRenderer.rect(tubeX[ii], Gdx.graphics.getHeight() / 2 - gap / 2 - bottomTube.getHeight() + tubeOffset[ii]
                    // bottomTube.getWidth(), bottomTube.getHeight());

            if (Intersector.overlaps(birdCircle,topTubeRectangles[ii]) || Intersector.overlaps(birdCircle,bottomTubeRectangles[ii])){

                Gdx.app.log("Collision?", "Yes!");
            }
        }
        //shapeRenderer.end();
	}
}
