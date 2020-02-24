package com.a1502999.game.level.tile;

import com.a1502999.game.graphics.Screen;
import com.a1502999.game.graphics.Sprite;

public class Tile {

    public int x, y;
    public Sprite sprite;

    public static Tile sand = new SandTile(Sprite.sand);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }

}