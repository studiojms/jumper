package br.com.jmsstudio.jumper.elements;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.jmsstudio.jumper.graphics.Screen;

/**
 * Created by jms on 13/01/17.
 */
public class Pipes {
    private static final int PIPES_SIZE = 5;
    private static final int DISTANCE_BETWEEN_PIPES = 300;

    private List<Pipe> pipes = new ArrayList<>();
    private Screen screen;
    private Score score;

    public Pipes(Screen screen, Score score) {
        this.screen = screen;
        this.score = score;
        int pos = 500;

        for (int i = 0; i < PIPES_SIZE; i++) {
            Pipe pipe = new Pipe(screen, pos);
            pipes.add(pipe);
            pos += DISTANCE_BETWEEN_PIPES;
        }
    }

    public void draw(Canvas canvas) {
        for (Pipe pipe : pipes) {
            pipe.draw(canvas);
        }
    }

    public void move() {
        ListIterator<Pipe> iterator = pipes.listIterator();

        while (iterator.hasNext()) {
            Pipe pipe = iterator.next();
            pipe.move();
            if (pipe.isOutOfTheScreen()) {
                this.score.inc();

                //removes the current item from the iterator
                iterator.remove();

                Pipe newPipe = new Pipe(this.screen, getLastPipePosition() + DISTANCE_BETWEEN_PIPES);

                //adds the new pipe to the iterator
                iterator.add(newPipe);
            }
        }
    }

    /**
     * Returns the left position of the uttermost pipe in the list
     */
    private int getLastPipePosition() {
        int lastPosition = 0;

        for (Pipe pipe : pipes) {
            lastPosition = Math.max(lastPosition, pipe.getPosition());
        }

        return lastPosition;
    }

    public boolean collidedWithBird(Bird bird) {
        boolean collided = false;
        Iterator<Pipe> pipeIterator = pipes.iterator();

        while (pipeIterator.hasNext() && !collided) {
            Pipe pipe = pipeIterator.next();
            collided = pipe.collidedWithBird(bird);
        }

        return collided;
    }
}
