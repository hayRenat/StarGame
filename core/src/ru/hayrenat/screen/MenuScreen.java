package ru.hayrenat.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.hayrenat.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 4f;

    private Texture img;
    private Texture background;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 touchPos;
    private Vector2 tmpV;


    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        background = new Texture("space.png");
        pos = new Vector2();
        v = new Vector2();
        touchPos = new Vector2();
        tmpV = new Vector2();

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(background, 0,0);
        batch.draw(img, pos.x, pos.y);
        batch.end();
        tmpV.set(touchPos);
        if (tmpV.sub(pos).len() <= v.len()){
            pos.set(touchPos);
        } else {
            pos.add(v);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchPos.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touchPos.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }
}
