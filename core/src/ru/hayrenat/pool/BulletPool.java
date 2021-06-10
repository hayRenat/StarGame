package ru.hayrenat.pool;

import ru.hayrenat.base.Bullet;
import ru.hayrenat.base.SpritesPool;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
