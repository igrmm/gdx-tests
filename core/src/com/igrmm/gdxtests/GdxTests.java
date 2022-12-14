package com.igrmm.gdxtests;

import com.badlogic.gdx.Game;

public class GdxTests extends Game {
	@Override
	public void create() {
		setScreen(new ShaderTest1());
	}

	@Override
	public void dispose() {
		screen.dispose();
	}
}
