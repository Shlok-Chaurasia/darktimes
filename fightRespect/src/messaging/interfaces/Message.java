package messaging.interfaces;

/**
 * Created by shlok.chaurasia on 25/02/16.
 */
public interface Message<T> {
    int getRank();
    T getData();
    int getId();
    void setRank(int rank);
    void setData(T data);
}
