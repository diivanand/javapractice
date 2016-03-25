package diiv.javapractice.util.collections;

import java.util.Comparator;


public interface DiivBalancedBinarySearchTree<T extends Comparable> {
    void insert(T obj);
    void remove(T obj);
    int size();
    boolean contains(T obj);
}
