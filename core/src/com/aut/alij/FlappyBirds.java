package com.aut.alij;

import com.aut.alij.states.GameStateManager;
import com.aut.alij.states.MenuState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBirds extends ApplicationAdapter {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    public static final String TITLE = "Flappy Birds";

    private Music music;
    private GameStateManager gameStateManager;
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gameStateManager = new GameStateManager();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
        gameStateManager.push(new MenuState(gameStateManager));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameStateManager.update(Gdx.graphics.getDeltaTime());
        gameStateManager.render(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
        music.dispose();
        batch.dispose();
    }
}
