package diiv.javapractice.util.collections;

import java.util.Iterator;

public class DiivArrayList<T> implements DiivList<T> {
    private static final int DEFAULT_CAPACITY = 10;

    public DiivArrayList()
    {
        _size = 0;
        _capacity = DEFAULT_CAPACITY;
        items = (T[]) new Object[_capacity];
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public boolean contains(T object) {
        for (T item : this)
        {
            if (item.equals(object))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void insert(T object) {
        if (_size == _capacity)
        {
            _capacity = _capacity * 2;
            T[] newItemsArray = (T[]) new Object[_capacity];
            for (int i = 0; i < items.length; i++)
            {
                newItemsArray[i] = items[i];
            }
            items = newItemsArray;
        }
        items[_size] = object;
        _size++;
    }

    @Override
    public void remove(T object) throws ArrayIndexOutOfBoundsException {
        if (_size == 0)
        {
            throw new ArrayIndexOutOfBoundsException("The array is empty");
        }

        int i = 0;
        for (; i < _size; i++)
        {
            if (items[i].equals(object))
            {
                for (;i < _size-1; i++)
                {
                    items[i] = items[i+1];
                }
                items[_size-1] = null;
                _size--;
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DiivArrayListIterator();
    }

    private int _size;
    private int _capacity;
    private T[] items;

    private class DiivArrayListIterator implements Iterator<T>
    {
        private int currIndex;

        public DiivArrayListIterator()
        {
            currIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currIndex != _size;
        }

        @Override
        public T next() {
            T value = items[currIndex];
            currIndex++;
            return value;
        }
    }
}
