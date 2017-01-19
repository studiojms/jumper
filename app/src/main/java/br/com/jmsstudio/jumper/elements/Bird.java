package br.com.jmsstudio.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import br.com.jmsstudio.jumper.R;
import br.com.jmsstudio.jumper.graphics.Screen;
import br.com.jmsstudio.jumper.sound.Sound;

/**
 * Created by jms on 09/01/17.
 */
public class Bird {
    private static final int HORIZONTAL_POSITION = 100;
    private static final int RADIUS = 50;
    private static final int JUMP_SIZE = 150;
    private static final int FALL_SIZE = 5;

    private int height;
    private Screen screen;
    private Sound sound;
    private Bitmap birdImage;

    public Bird(Screen screen, Context context, Sound sound) {
        this.height = screen.getHeight()/2 - RADIUS;
        this.screen = screen;
        this.sound = sound;

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.birdImage = Bitmap.createScaledBitmap(bitmap, RADIUS * 2, RADIUS * 2, false);
    }

    public void draw(Canvas canvas) {
//        canvas.drawCircle(HORIZONTAL_POSITION, height, RADIUS, ColorHelper.getBirdColor());
        canvas.drawBitmap(birdImage, HORIZONTAL_POSITION - RADIUS, height - RADIUS, null);
    }

    public void fall() {
        boolean canFall = (this.height + RADIUS + FALL_SIZE) <= screen.getHeight();

        if (canFall) {
            this.height += FALL_SIZE;
        }
    }

    public void jump() {
        this.height -= JUMP_SIZE;

        this.sound.playJump();

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
        return HORIZONTAL_POSITION + RADIUS;
    }
}
