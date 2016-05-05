package patterns.observer.impl;

import patterns.observer.interfaces.DisplayElement;
import patterns.observer.interfaces.Publisher;
import patterns.observer.interfaces.Subscriber;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public class CurrentConditionDisplay implements DisplayElement,Subscriber {
    Publisher publisher;

    public CurrentConditionDisplay(Publisher publisher) {
        this.publisher = publisher;
        publisher.registerSubscriber(this);
    }

    public void display() {

    }

    public void update(String dataRequestToObserver) {

        display();
    }
}
