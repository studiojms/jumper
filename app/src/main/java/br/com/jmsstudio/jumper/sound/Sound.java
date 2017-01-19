package br.com.jmsstudio.jumper.sound;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import br.com.jmsstudio.jumper.R;

/**
 * Created by jms on 19/01/17.
 */
public class Sound {

    private SoundPool soundPool;

    private final int JUMP;
    private final int COLLISION;
    private final int SCORE;

    public Sound(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            this.soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(3)
                    .build();
        } else {
            this.soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        }

        JUMP = this.soundPool.load(context, R.raw.pulo, 0);
        SCORE = this.soundPool.load(context, R.raw.pontos, 0);
        COLLISION = this.soundPool.load(context, R.raw.colisao, 0);
    }

    private void play(int soundId) {
        soundPool.play(soundId, 1, 1, 1, 0, 1);
    }

    public void playJump() {
        play(JUMP);
    }

    public void playCollision() {
        play(COLLISION);
    }

    public void playScore() {
        play(SCORE);
    }
}
