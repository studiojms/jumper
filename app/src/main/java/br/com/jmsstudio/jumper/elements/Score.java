package br.com.jmsstudio.jumper.elements;

import android.graphics.Canvas;

import br.com.jmsstudio.jumper.graphics.ColorHelper;
import br.com.jmsstudio.jumper.sound.Sound;

/**
 * Created by jms on 17/01/17.
 */
public class Score {

    private Integer score = 0;
    private Sound sound;

    public Score(Sound sound) {
        this.sound = sound;
    }

    public void draw(Canvas canvas) {
        canvas.drawText(score.toString(), 100, 100, ColorHelper.getScoreColor());
    }

    public void inc() {
        sound.playScore();
        score++;
    }
}
