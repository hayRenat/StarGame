package ru.hayrenat.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.hayrenat.base.BaseScreen;
import ru.hayrenat.math.Rect;
import ru.hayrenat.sprite.Background;
import ru.hayrenat.sprite.Ship;

public class MenuScreen extends BaseScreen {

    private Ship ship;
    private Texture backgroundTexture;
    private Background background;


    @Override
    public void show() {
        super.show();
        backgroundTexture = new Texture("space.png");
        background = new Background(backgroundTexture);
        ship = new Ship(new Texture("ship.png"));

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ship.update(delta);
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        background.draw(batch);
        ship.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        backgroundTexture.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        ship.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        ship.touchDown(touch, pointer, button);
        return false;
    }
}
