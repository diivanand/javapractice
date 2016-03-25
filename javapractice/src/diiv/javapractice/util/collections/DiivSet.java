package diiv.javapractice.util.collections;


public interface DiivSet<T> {
    void insert(T obj);
    void remove(T obj);
    boolean contains(T obj);
    int size();
}
