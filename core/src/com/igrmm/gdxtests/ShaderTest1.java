package com.igrmm.gdxtests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class ShaderTest1 extends ScreenAdapter {
	OrthographicCamera cam;
	SpriteBatch batch;
	Texture img;
	Vector3 playerPosition;
	float offset;

	ShaderProgram shader;

	public ShaderTest1() {
		cam = new OrthographicCamera();
		cam.position.set(16f, 16f, 0f);
//		cam.zoom = 1f / 16f;
//		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		batch = new SpriteBatch();
		img = new Texture("img.png");
		playerPosition = new Vector3();

		shader = new ShaderProgram(batch.getShader().getVertexShaderSource(), Gdx.files.internal("smoothsubpixel.frag").readString());
		if (!shader.isCompiled()) {
			System.out.println(shader.getLog());
		}
		ShaderProgram.pedantic = false;
	}

	public void cameraFollow(float delta) {
		playerPosition.x += 235.8473847f * delta;
		cam.position.lerp(playerPosition, 6f * delta);
		offset = 54f;
	}

	@Override
	public void render(float delta) {
//		cameraFollow(delta);

		playerPosition.x = Gdx.input.getX();
		playerPosition.y = (-Gdx.input.getY() + Gdx.graphics.getHeight());

		ScreenUtils.clear(1, 0, 0, 1);
//		cam.update();
		batch.setShader(shader);
//		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(img, playerPosition.x, playerPosition.y);
		batch.end();
		batch.setShader(null);
	}

	@Override
	public void resize(int width, int height) {
		cam.viewportWidth = width;
		cam.viewportHeight = height;
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
