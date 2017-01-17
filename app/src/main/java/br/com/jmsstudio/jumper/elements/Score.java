package br.com.jmsstudio.jumper.elements;

import android.graphics.Canvas;

import br.com.jmsstudio.jumper.graphics.ColorHelper;

/**
 * Created by jms on 17/01/17.
 */
public class Score {

    private Integer score = 0;

    public void draw(Canvas canvas) {
        canvas.drawText(score.toString(), 100, 100, ColorHelper.getScoreColor());
    }

    public void inc() {
        score++;
    }
}
