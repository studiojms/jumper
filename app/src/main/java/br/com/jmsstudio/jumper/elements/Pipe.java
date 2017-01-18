package br.com.jmsstudio.jumper.elements;

import android.graphics.Canvas;

import br.com.jmsstudio.jumper.graphics.ColorHelper;
import br.com.jmsstudio.jumper.graphics.Screen;

/**
 * Created by jms on 12/01/17.
 */
public class Pipe {
    private static final int PIPE_HEIGHT = 250;
    private static final int PIPE_WIDTH = 100;

    private Screen screen;
    private int position;
    private int bottomPipeHeight;
    private int upperPipeHeight;

    public Pipe(Screen screen, int position) {
        this.screen = screen;
        this.position = position;
        this.bottomPipeHeight = screen.getHeight() - PIPE_HEIGHT - getRandomValue();
        this.upperPipeHeight = PIPE_HEIGHT + getRandomValue();
    }

    public void draw(Canvas canvas) {
        drawUpperPipe(canvas);
        drawBottomPipe(canvas);
    }

    public void drawBottomPipe(Canvas canvas) {
        canvas.drawRect(this.position, bottomPipeHeight, this.position + PIPE_WIDTH, screen.getHeight(), ColorHelper.getPipeColor());
    }

    public void drawUpperPipe(Canvas canvas) {
        canvas.drawRect(this.position, 0, this.position + PIPE_WIDTH, upperPipeHeight, ColorHelper.getPipeColor());
    }

    public void move() {
        this.position -= 5;
    }

    public int getRandomValue() {
        return (int) (Math.random() * 200);
    }

    public boolean isOutOfTheScreen() {
        return position + PIPE_WIDTH < 0;
    }

    public int getPosition() {
        return position;
    }

    public boolean collidedWithBird(Bird bird) {

        boolean yAxisCollided = bird.getVerticalTopPosition() < this.upperPipeHeight || bird.getVerticalBottomPosition() > this.bottomPipeHeight;
        boolean xAxisCollided = bird.getRightPosition() > this.position && this.position > 0;

        return xAxisCollided && yAxisCollided;
    }
}
