package messaging.impl;

import messaging.interfaces.Message;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public class MessageImpl<T> implements Message<T> , Comparable<T>{
    public static int id=0;
    int messageId;
    int rank;
    T data;
    int groupId;

    public MessageImpl() {
        rank = 1;
        messageId = MessageImpl.id++;
        groupId=-1;
    }
    public MessageImpl(int groupId) {
        rank = 1;
        messageId = MessageImpl.id++;
        this.groupId=groupId;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MessageImpl(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(T o) {
        return this.getRank() - ((Message<T>)o).getRank();
    }

    @Override
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {

        this.rank = rank;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public int getId() {
        return this.messageId;
    }
}
