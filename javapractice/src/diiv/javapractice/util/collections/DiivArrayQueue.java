package diiv.javapractice.util.collections;


import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;

public class DiivArrayQueue<T> implements DiivQueue<T> {
    public DiivArrayQueue() {
        _capacity = DEFAULT_CAPACITY;
        commonConstructorSetting();
    }

    public DiivArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be a positive integer");
        }
        _capacity = capacity;
        commonConstructorSetting();
    }

    private void commonConstructorSetting() {
        _size = 0;
        _frontIndex = 0;
        _backIndex = 0;
        _arr = (T[]) new Object[_capacity];
    }

    @Override
    public void enqueue(T obj) {
        if (_size == _capacity) {
            throw new IllegalArgumentException("Queue is full, cannot enqueue");
        }
        _arr[_backIndex] = obj;
        _backIndex++;
        if (_backIndex == _capacity) {
            _backIndex = 0;
        }
        _size++;
    }

    @Override
    public T dequeue() {
        if (_size == 0) {
            throw new IllegalArgumentException("Queue is empty, cannot dequeue");
        }
        T item = _arr[_frontIndex];
        _frontIndex++;
        _size--;
        return item;
    }

    @Override
    public T front() {
        if (_size == 0) {
            throw new IllegalArgumentException("Queue is empty, no front item");
        }
        return _arr[_frontIndex];
    }

    @Override
    public int size() {
        return _size;
    }

    private T[] _arr;
    private int _frontIndex;
    private int _backIndex;
    private int _size;
    private int _capacity;
    private final int DEFAULT_CAPACITY = 5;
}
