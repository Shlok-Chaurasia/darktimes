package patterns.strategy;

import patterns.strategy.impl.FlyWithWings;
import patterns.strategy.impl.Squeak;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public class Type1Duck extends Duck {

    public Type1Duck() {
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Squeak();
    }


}
