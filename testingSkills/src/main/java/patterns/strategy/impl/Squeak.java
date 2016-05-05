package patterns.strategy.impl;

import patterns.strategy.interfaces.QuackBehaviour;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public class Squeak implements QuackBehaviour {
    public void quack() {
        System.out.println("Squeaking....");
    }
}
