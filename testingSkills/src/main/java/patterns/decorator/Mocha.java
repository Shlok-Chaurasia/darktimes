package patterns.decorator;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return this.beverage.cost() + .90;
    }

    @Override
    public String getDescription() {
        return "Mocha";
    }
}
