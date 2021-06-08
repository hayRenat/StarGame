package ru.hayrenat.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.hayrenat.base.Sprite;
import ru.hayrenat.math.Rect;

public class Background extends Sprite {

    public Background(Texture texture) {
        super (new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(1f);
        this.pos.set(worldBounds.pos);
    }
}
