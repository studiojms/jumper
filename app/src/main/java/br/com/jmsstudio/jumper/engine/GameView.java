package br.com.jmsstudio.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.jmsstudio.jumper.R;
import br.com.jmsstudio.jumper.elements.Bird;
import br.com.jmsstudio.jumper.elements.GameOver;
import br.com.jmsstudio.jumper.elements.Pipes;
import br.com.jmsstudio.jumper.elements.Score;
import br.com.jmsstudio.jumper.graphics.Screen;
import br.com.jmsstudio.jumper.sound.Sound;

/**
 * Created by jms on 09/01/17.
 */
public class GameView extends SurfaceView implements Runnable, View.OnTouchListener{
    private boolean isRunning = true;
    private Bird bird;
    private Bitmap background;
    private Screen screen;
    private Context context;
    private Pipes pipes;
    private Score score;
    private GameOver gameOver;
    private Sound sound;

    public GameView(Context context) {
        super(context);

        this.screen = new Screen(context);
        this.context = context;
        setOnTouchListener(this);
        init();
    }

    private void init() {
        this.sound = new Sound(context);
        this.bird = new Bird(screen, context, sound);
        this.score = new Score(sound);
        this.pipes = new Pipes(screen, score, context);
        Bitmap backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.background = Bitmap.createScaledBitmap(backgroundImage, backgroundImage.getWidth(), this.screen.getHeight(), false);
    }

    @Override
    public void run() {
        SurfaceHolder holder = getHolder();

        while (isRunning) {
            if (holder.getSurface().isValid()) {
                Canvas canvas = holder.lockCanvas();

                canvas.drawBitmap(this.background, 0, 0, null);

                this.bird.draw(canvas);
                this.bird.fall();

                this.pipes.draw(canvas);
                this.pipes.move();

                this.score.draw(canvas);

                CollisionDetector collisionDetector = new CollisionDetector(this.bird, this.pipes);
                if (collisionDetector.didCollide()) {
                    this.sound.playCollision();
                    isRunning = false;
                    renderGameOver(canvas);
                }

                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    /**
     * Renders the game over message
     *
     * @param canvas
     */
    private void renderGameOver(Canvas canvas) {
        if (this.gameOver == null) {
            this.gameOver = new GameOver(this.screen);
        }
        this.gameOver.draw(canvas);
    }

    public void start() {
        this.isRunning = true;
    }

    public void cancel() {
        this.isRunning = false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (isRunning) {
            this.bird.jump();
        } else {
            restart();
        }
        return false;
    }

    private void restart() {
        Canvas canvas = getHolder().lockCanvas();

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        canvas.drawRect(0, 0, this.screen.getWidth(), this.screen.getHeight(), paint);
        getHolder().unlockCanvasAndPost(canvas);
        init();
        start();
    }

    public boolean isEnded() {
        return this.gameOver != null;
    }
}
