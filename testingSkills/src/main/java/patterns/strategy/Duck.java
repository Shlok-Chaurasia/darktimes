package patterns.strategy;

import patterns.strategy.interfaces.FlyBehaviour;
import patterns.strategy.interfaces.QuackBehaviour;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */

// Use this when Different behaviours/combination of behaviours determine each type of object.
// Create Unique behaviour/algos and then use for each different type.
// Instead of hardcoding in the child class of Duck for each behaviour you can use factory pattern to assign behaviour.
// Another real_world example:
// King,Queen,Knight each has its own Weapon Behaviours
public class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public void performFly(){
        flyBehaviour.fly();
    }

    public void performQuack(){
        quackBehaviour.quack();
    }
}
