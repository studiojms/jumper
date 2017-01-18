package br.com.jmsstudio.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.jmsstudio.jumper.graphics.ColorHelper;
import br.com.jmsstudio.jumper.graphics.Screen;

/**
 * Created by jms on 17/01/17.
 */
public class GameOver {
    private Screen screen;

    public GameOver(Screen screen) {
        this.screen = screen;
    }

    public void draw(Canvas canvas) {
        final String gameOverMessage = "Game Over";
        final String restartMessage = "Toque para reiniciar";

        final int horizontalTextCenter = calculateTextHorizontalCenterPosition(gameOverMessage, ColorHelper.getGameOverColor());

        final int screenHeightQuarter = screen.getHeight()/4;

        canvas.drawRect(0, screenHeightQuarter, screen.getWidth(), screenHeightQuarter * 3, ColorHelper.getGameOverBackground());
        canvas.drawText(gameOverMessage, horizontalTextCenter, screen.getHeight()/2, ColorHelper.getGameOverColor());


        canvas.drawText(restartMessage, calculateTextHorizontalCenterPosition(restartMessage, ColorHelper.getGameOverRestartMessageColor()), screenHeightQuarter * 2 + screenHeightQuarter/4, ColorHelper.getGameOverRestartMessageColor());
    }

    /**
     * Calculates the X position of the center of the text
     *
     * @param text - text to be centered
     * @param colorConfig - color configuration of the text
     * @return the X position of the center of the text
     */
    private int calculateTextHorizontalCenterPosition(String text, Paint colorConfig) {
        Rect textBounds = new Rect();
        colorConfig.getTextBounds(text, 0, text.length(), textBounds);

        int horizontalScreenCenter = screen.getWidth() / 2;
        int horizontalTextPosition = (textBounds.right - textBounds.left) / 2;

        //returns the position to center the text on the horizontal axis
        return horizontalScreenCenter - horizontalTextPosition;
    }
}
