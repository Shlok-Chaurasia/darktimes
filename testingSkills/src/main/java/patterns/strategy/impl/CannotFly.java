package patterns.strategy.impl;

import patterns.strategy.interfaces.FlyBehaviour;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public class CannotFly implements FlyBehaviour {
    public void fly() {
        System.out.println("Cannot fly");
    }
}
