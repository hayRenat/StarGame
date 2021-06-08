package ru.hayrenat.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.hayrenat.base.ScaledButton;
import ru.hayrenat.math.Rect;
import ru.hayrenat.screen.GameScreen;

public class PlayButton extends ScaledButton {

    private static final float HEIGHT = 0.26f;
    private static final float PADDING = 0.05f;

    private Game game;

    public PlayButton(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    protected void action() {
        game.setScreen(new GameScreen());

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + PADDING);
        setLeft(worldBounds.getLeft() + PADDING);
    }
}
