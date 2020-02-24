package com.a1502999.game.entity.mob;

import com.a1502999.game.graphics.Screen;
import com.a1502999.game.graphics.Sprite;
import com.a1502999.game.input.Keyboard;

import static com.a1502999.game.graphics.Sprite.player_back;
import static com.a1502999.game.graphics.Sprite.playerf;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int anim = 0, step = 0, count = 0;
    private boolean walking = false;

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.player_forward;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }

    public void update() {
        int xa = 0, ya = 0;

        if (anim < 40) anim++;
        else anim = 0;

        step++;
        if (step > 7) {
            step = 0;
        }

        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
    }

    public void render(Screen screen) {
        if (dir == 0) {
            sprite = Sprite.player_back;
            if (walking) {
                if (anim % 40 > 35) {
                    sprite = Sprite.player_back_4;
                } else if (anim % 40 > 30) {
                    sprite = Sprite.player_back;
                } else if (anim % 40 > 25) {
                    sprite = Sprite.player_back_1;
                } else if (anim % 40 > 20) {
                    sprite = Sprite.player_back_2;
                } else if (anim % 40 > 15) {
                    sprite = Sprite.player_back_3;
                } else if (anim % 40 > 10) {
                    sprite = Sprite.player_back_2;
                } else if (anim % 40 > 5) {
                    sprite = Sprite.player_back_1;
                }
            }
        }

        if (dir == 1) {
            sprite = Sprite.player_right;
            if (walking) {
                if (anim % 40 > 35) {
                    sprite = Sprite.player_right_4;
                } else if (anim % 40 > 30) {
                    sprite = Sprite.player_right;
                } else if (anim % 40 > 25) {
                    sprite = Sprite.player_right_1;
                } else if (anim % 40 > 20) {
                    sprite = Sprite.player_right_2;
                } else if (anim % 40 > 15) {
                    sprite = Sprite.player_right_3;
                } else if (anim % 40 > 10) {
                    sprite = Sprite.player_right_2;
                } else if (anim % 40 > 5) {
                    sprite = Sprite.player_right_1;
                }
            }
        }

        if (dir == 2) {
            sprite = Sprite.player_forward;
            if (walking) {
                if (anim % 40 > 35) {
                    sprite = Sprite.player_forward_4;
                } else if (anim % 40 > 30) {
                    sprite = Sprite.player_forward;
                } else if (anim % 40 > 25) {
                    sprite = Sprite.player_forward_1;
                } else if (anim % 80 > 40) {
                    sprite = Sprite.player_forward_2;
                } else if (anim % 80 > 30) {
                    sprite = Sprite.player_forward_3;
                } else if (anim % 80 > 20) {
                    sprite = Sprite.player_forward_2;
                } else if (anim % 80 > 10) {
                    sprite = Sprite.player_forward_1;
                }
            }
        }

        if (dir == 3) {
            sprite = Sprite.player_left;
            if (walking) {
                if (anim % 80 > 70) {
                    sprite = Sprite.player_left_4;
                } else if (anim % 80 > 60) {
                    sprite = Sprite.player_left;
                } else if (anim % 80 > 50) {
                    sprite = Sprite.player_left_1;
                } else if (anim % 80 > 40) {
                    sprite = Sprite.player_left_2;
                } else if (anim % 80 > 30) {
                    sprite = Sprite.player_left_3;
                } else if (anim % 80 > 20) {
                    sprite = Sprite.player_left_2;
                } else if (anim % 80 > 10) {
                    sprite = Sprite.player_left_1;
                }
            }
        }

        screen.renderPlayer(x, y, sprite);
    }

    public Sprite getSprite() {



        //System.out.println(count);


        switch(dir){
            case 0:
                return Sprite.playerf[count];
            case 1:
                return Sprite.playerr[count];
            case 2:
                return Sprite.playerf[3];
            case 3:
                return Sprite.playerl[3];
            default:
                return Sprite.playerr[count];
        }
    }


}
