package ru.hayrenat.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.hayrenat.base.BaseScreen;
import ru.hayrenat.math.Rect;
import ru.hayrenat.sprite.Background;
import ru.hayrenat.sprite.Ship;
import ru.hayrenat.sprite.Star;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 80;

    private Game game;
    private Ship ship;
    private TextureAtlas atlas;
    private Star[] stars;

    private Texture backgroundTexture;
    private Background background;

    @Override
    public void show() {
        super.show();
        backgroundTexture = new Texture("textures/space.png");
        background = new Background(backgroundTexture);
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        ship = new Ship(atlas);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars){
            star.resize(worldBounds);
        }
        ship.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        backgroundTexture.dispose();
        atlas.dispose();
    }

    private void update(float delta){
        for (Star star : stars){
            star.update(delta);
        }
        ship.update(delta);
    }

    private void draw() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        background.draw(batch);
        ship.draw(batch);
        for (Star star : stars){
            star.draw(batch);
        }
        batch.end();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        ship.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        ship.touchUp(touch, pointer, button);
        return false;
    }


    @Override
    public boolean keyDown(int keycode) {
        ship.keyDown(keycode);
        return false;
    }
}
