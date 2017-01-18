package br.com.jmsstudio.jumper.engine;

import br.com.jmsstudio.jumper.elements.Bird;
import br.com.jmsstudio.jumper.elements.Pipes;

/**
 * Created by jms on 17/01/17.
 */
public class CollisionDetector {
    private Bird bird;
    private Pipes pipes;

    public CollisionDetector(Bird bird, Pipes pipes) {
        this.bird = bird;
        this.pipes = pipes;
    }

    /**
     * Checks if there is some collision between the bird and the pipes
     */
    public boolean didCollide() {
        return pipes.collidedWithBird(bird);
    }
}
