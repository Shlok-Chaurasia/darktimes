package patterns.decorator;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public abstract class Beverage {
    String description = "Unknown Beverages";
    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
