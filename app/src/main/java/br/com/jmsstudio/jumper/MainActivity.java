package br.com.jmsstudio.jumper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import br.com.jmsstudio.jumper.engine.GameView;

public class MainActivity extends Activity {

    private GameView game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = (FrameLayout) findViewById(R.id.game_container);

        this.game = new GameView(this);
        container.addView(this.game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.game.start();
        new Thread(this.game).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.game.cancel();
    }
}
