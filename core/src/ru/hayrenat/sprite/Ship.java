package ru.hayrenat.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.hayrenat.base.Sprite;
import ru.hayrenat.math.Rect;

public class Ship extends Sprite {

    private static final float V_LEN = 0.006f;
    private Vector2 speed;
    private Vector2 touch;
    private Vector2 tmpV ;

    public Ship(Texture texture) {
        super(new TextureRegion(texture));
        this.speed = new Vector2();
        this.tmpV = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.1f);
        this.pos.set(worldBounds.pos);
        setHeightProportion(0.15f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        speed.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    @Override
    public void update(float delta) {
        tmpV.set(touch);
        if (tmpV.sub(pos).len() <= V_LEN) {
            pos.set(touch);
            speed.set(0, 0);
        } else {
            pos.add(speed);
        }
    }
}
