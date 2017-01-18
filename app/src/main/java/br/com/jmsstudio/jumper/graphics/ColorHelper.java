package br.com.jmsstudio.jumper.graphics;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by jms on 09/01/17.
 */
public class ColorHelper {
    public static Paint getBirdColor() {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
//        paint.setColor(0xFFFF0000);
        return paint;
    }

    public static Paint getPipeColor() {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        return paint;
    }

    public static Paint getScoreColor() {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3, 5, 5, Color.BLACK);
        return paint;
    }

    public static Paint getGameOverBackground() {
        Paint paint = new Paint();
        paint.setColor(0xAA000000);
        return paint;
    }

    public static Paint getGameOverColor() {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(2, 3, 3, Color.GRAY);
        return paint;
    }

    public static Paint getGameOverRestartMessageColor() {
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize(20);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
//        paint.setShadowLayer(2, 3, 3, Color.WHITE);
        return paint;
    }
}
