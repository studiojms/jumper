package br.com.jmsstudio.jumper.graphic;

import android.graphics.Paint;

/**
 * Created by jms on 09/01/17.
 */
public class ColorHelper {
    public static Paint getBirdColor() {
        Paint paint = new Paint();
        paint.setColor(android.graphics.Color.RED);
//        paint.setColor(0xFFFF0000);
        return paint;
    }
}
