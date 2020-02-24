package com.a1502999.game.entity.mob;

import com.a1502999.game.entity.Entity;
import com.a1502999.game.graphics.Sprite;

public class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move(int xa, int ya) {
        if (xa > 0) dir = 1;
        if (xa < 0) dir = 3;
        if (ya > 0) dir = 2;
        if (ya < 0) dir = 0;

        if (!collision()) {
            x += xa;
            y += ya;
        }
    }

    public void update() {

    }

    private boolean collision() {
        return false;
    }

    public void render() {

    }

}