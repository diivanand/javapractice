package diiv.javapractice.util.collections;


public interface DiivQueue<T> {
    void enqueue(T obj);
    T dequeue();
    T front();
    int size();
}
