package diiv.javapractice.util.collections;


public interface DiivStack<T> {
    void push(T obj);
    T pop();
    T peek();
    int size();
}
