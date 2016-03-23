package diiv.javapractice.util.collections;


public interface DiivList<T> extends Iterable<T> {
    int size();
    boolean contains(T object);
    void insert(T object);
    void remove(T object);
}
