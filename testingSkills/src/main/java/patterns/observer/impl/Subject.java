package patterns.observer.impl;

import patterns.observer.interfaces.Publisher;
import patterns.observer.interfaces.Subscriber;

import java.util.ArrayList;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public class Subject implements Publisher {
    String requestData;
    ArrayList<Subscriber> subscribers;
    public void registerSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for(Subscriber subscriber:subscribers){
            subscriber.update(this.requestData);
        }
    }
    public void changeRequestData(String requestData){
        this.requestData = requestData;
        notifySubscribers();
    }
}
