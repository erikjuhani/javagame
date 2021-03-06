package com.a1502999.game.level.tile;

import com.a1502999.game.graphics.Screen;
import com.a1502999.game.graphics.Sprite;

public class VoidTile extends Tile {

    public VoidTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
