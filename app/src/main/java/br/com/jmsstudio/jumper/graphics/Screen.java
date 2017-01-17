package br.com.jmsstudio.jumper.graphics;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by jms on 10/01/17.
 */
public class Screen {

    private DisplayMetrics displayMetrics;

    public Screen(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
    }

    public int getHeight() {
        return displayMetrics.heightPixels;
    }
}
