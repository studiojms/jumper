package br.com.jmsstudio.jumper.elements;

import android.graphics.Canvas;

import br.com.jmsstudio.jumper.graphic.ColorHelper;

/**
 * Created by jms on 09/01/17.
 */
public class Bird {
    private static final int WIDTH = 100;
    private static final int RADIUS = 50;
    private static final int JUMP_SIZE = 150;

    private int height;

    public Bird() {
        this.height = 100;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(WIDTH, height, RADIUS, ColorHelper.getBirdColor());
    }

    public void fall() {
        this.height += 5;
    }

    public void jump() {
        this.height -= JUMP_SIZE;
    }
}
