package br.com.jmsstudio.jumper.elements;

import android.graphics.Canvas;

import br.com.jmsstudio.jumper.graphics.ColorHelper;
import br.com.jmsstudio.jumper.graphics.Screen;

/**
 * Created by jms on 09/01/17.
 */
public class Bird {
    private static final int WIDTH = 100;
    private static final int RADIUS = 50;
    private static final int JUMP_SIZE = 150;
    private static final int FALL_SIZE = 5;

    private int height;
    private Screen screen;

    public Bird(Screen screen) {
        this.height = screen.getHeight()/2 - RADIUS;
        this.screen = screen;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(WIDTH, height, RADIUS, ColorHelper.getBirdColor());
    }

    public void fall() {
        boolean canFall = (this.height + RADIUS + FALL_SIZE) <= screen.getHeight();

        if (canFall) {
            this.height += FALL_SIZE;
        }
    }

    public void jump() {
        this.height -= JUMP_SIZE;

        if (this.height < RADIUS) {
            this.height = RADIUS;
        }
    }

    /**
     * Returns the Y coordinate of the top of the bird
     */
    public int getVerticalTopPosition() {
        return height - RADIUS;
    }

    /**
     * Returns the Y coordinate of the bottom of the bird
     */
    public int getVerticalBottomPosition() {
        return height + RADIUS;
    }

    /**
     * Returns the X coordinate of the right side of the bird
     */
    public int getRightPosition() {
        return WIDTH + RADIUS;
    }
}
