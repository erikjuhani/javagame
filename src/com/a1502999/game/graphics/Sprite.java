package com.a1502999.game.graphics;

public class Sprite {

    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite sand = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0x1b0c02);

    public static Sprite player_forward = new Sprite(16, 0, 12, SpriteSheet.tiles);
    public static Sprite player_back = new Sprite(16, 1, 12, SpriteSheet.tiles);
    public static Sprite player_left = new Sprite(16, 2, 12, SpriteSheet.tiles);

    public static Sprite player_forward_1 = new Sprite(16, 0, 13, SpriteSheet.tiles);
    public static Sprite player_forward_2 = new Sprite(16, 0, 14, SpriteSheet.tiles);
    public static Sprite player_forward_3 = new Sprite(16, 0, 15, SpriteSheet.tiles);
    public static Sprite player_forward_4 = new Sprite(16, 0, 11, SpriteSheet.tiles);

    public static Sprite[] playerf = { player_forward_4, player_forward, player_forward_1, player_forward_2,
                                        player_forward_3, player_forward_2, player_forward_1, player_forward };


    public static Sprite player_back_1 = new Sprite(16, 1, 13, SpriteSheet.tiles);
    public static Sprite player_back_2 = new Sprite(16, 1, 14, SpriteSheet.tiles);
    public static Sprite player_back_3 = new Sprite(16, 1, 15, SpriteSheet.tiles);
    public static Sprite player_back_4 = new Sprite(16, 1, 11, SpriteSheet.tiles);

    public static Sprite[] playerb = { player_back, player_back_1, player_back_2,
                                        player_back_3, player_back_4};

    public static Sprite player_left_1 = new Sprite(16, 2, 13, SpriteSheet.tiles);
    public static Sprite player_left_2 = new Sprite(16, 2, 14, SpriteSheet.tiles);
    public static Sprite player_left_3 = new Sprite(16, 2, 15, SpriteSheet.tiles);
    public static Sprite player_left_4 = new Sprite(16, 2, 11, SpriteSheet.tiles);

    public static Sprite[] playerl = { player_left, player_left_1, player_left_2,
                                        player_left_3, player_left_4};

    public static Sprite player_right = new Sprite(16, 3, 12, SpriteSheet.tiles);
    public static Sprite player_right_1 = new Sprite(16, 3, 13, SpriteSheet.tiles);
    public static Sprite player_right_2 = new Sprite(16, 3, 14, SpriteSheet.tiles);
    public static Sprite player_right_3 = new Sprite(16, 3, 15, SpriteSheet.tiles);
    public static Sprite player_right_4 = new Sprite(16, 3, 11, SpriteSheet.tiles);

    public static Sprite[] playerr = { player_right, player_right_1, player_right_2,
                                        player_right_3, player_right_4};

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int colour) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColour(colour);
    }

    private void setColour(int colour) {
        for (int i = 0; i < SIZE*SIZE; i++) {
            pixels[i] = colour;
        }
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
            }
        }
    }

}
