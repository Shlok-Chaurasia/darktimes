package messaging.interfaces;

import messaging.interfaces.Message;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class Receiver<T> {
    static int id = 1;
    int receiverId;
    public Receiver() {
        receiverId = id++;
    }

    public void receiveMessage(Message<T> message){
        System.out.println("Receiver "+receiverId+ " : "+"received message with id: "+ message.getId()+", data" +
                ":"+ message.getData() + " with Rank: " + message.getRank());

    }
}
