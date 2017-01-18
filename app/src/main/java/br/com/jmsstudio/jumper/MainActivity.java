package br.com.jmsstudio.jumper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import br.com.jmsstudio.jumper.engine.GameView;

public class MainActivity extends Activity {

    private GameView game;
    private Thread gameThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = (FrameLayout) findViewById(R.id.game_container);

        this.game = new GameView(this);
        container.addView(this.game);

        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.this.game.isEnded()) {
                    startGame();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        startGame();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.game.cancel();
    }

    private void startGame() {
        this.game.start();
        this.gameThread = new Thread(this.game);

        this.gameThread.start();
    }
}
