package patterns.strategy.impl;

import patterns.strategy.interfaces.FlyBehaviour;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public class FlyWithoutWings implements FlyBehaviour {
    public void fly() {
        System.out.println("Flying without wings");
    }
}
