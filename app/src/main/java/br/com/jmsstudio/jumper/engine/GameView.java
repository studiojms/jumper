package br.com.jmsstudio.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.jmsstudio.jumper.R;
import br.com.jmsstudio.jumper.elements.Bird;
import br.com.jmsstudio.jumper.graphic.Screen;

/**
 * Created by jms on 09/01/17.
 */
public class GameView extends SurfaceView implements Runnable, View.OnTouchListener{
    private boolean isRunning = true;
    private Bird bird;
    private Bitmap background;
    private Screen screen;

    public GameView(Context context) {
        super(context);

        this.screen = new Screen(context);
        setOnTouchListener(this);
        init();
    }

    private void init() {
        this.bird = new Bird();
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

                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void start() {
        this.isRunning = true;
    }

    public void cancel() {
        this.isRunning = false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.bird.jump();
        return false;
    }
}
