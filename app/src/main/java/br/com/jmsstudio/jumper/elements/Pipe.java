package br.com.jmsstudio.jumper.elements;

import android.graphics.Canvas;

import br.com.jmsstudio.jumper.graphic.ColorHelper;
import br.com.jmsstudio.jumper.graphic.Screen;

/**
 * Created by jms on 12/01/17.
 */
public class Pipe {
    private static final int PIPE_HEIGHT = 250;
    private static final int PIPE_WIDTH = 100;

    private Screen screen;
    private int position;

    public Pipe(Screen screen, int position) {
        this.screen = screen;
        this.position = position;
    }

    public void draw(Canvas canvas) {
        drawBottomPipe(canvas);
    }

    public void drawBottomPipe(Canvas canvas) {
        int bottomPipeHeight = screen.getHeight() - PIPE_HEIGHT;

        canvas.drawRect(this.position, bottomPipeHeight, this.position + PIPE_WIDTH, screen.getHeight(), ColorHelper.getPipeColor());
    }

    public void move() {
        this.position -= 5;
    }
}
