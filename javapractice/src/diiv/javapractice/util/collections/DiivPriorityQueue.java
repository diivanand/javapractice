package diiv.javapractice.util.collections;


import java.util.Comparator;

public interface DiivPriorityQueue<T extends Comparable> extends DiivQueue<T> {
    T getMin();
}
