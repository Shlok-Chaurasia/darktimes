package patterns.decorator;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public class Espresso extends Beverage {
    public Espresso() {
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return .89;
    }
}
