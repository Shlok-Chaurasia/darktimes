package patterns.observer.interfaces;

/**
 * Created by shlok.chaurasia on 02/02/16.
 */
public interface Publisher {
    void registerSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();
}
