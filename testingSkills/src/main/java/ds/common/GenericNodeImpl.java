package ds.common;

/**
 * Created by shlok.chaurasia on 20/02/16.
 */
public class GenericNodeImpl<T> implements GenericNode<T> {
    T data;

    public GenericNodeImpl(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
