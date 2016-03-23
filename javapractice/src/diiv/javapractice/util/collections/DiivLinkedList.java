package diiv.javapractice.util.collections;

import java.util.Iterator;

public class DiivLinkedList<T> implements DiivList<T> {

    public DiivLinkedList()
    {
        _size = 0;
        _front = null;
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
        if (_front == null)
        {
            _front = new ListNode<T>(object, null);
        }
        else
        {
            ListNode<T> curr = _front;
            while (curr.next != null)
            {
                curr = curr.next;
            }
            curr.next = new ListNode<T>(object, null);
        }
        _size++;
    }

    @Override
    public void remove(T object) throws ArrayIndexOutOfBoundsException {
        if (_size == 0)
        {
            throw new ArrayIndexOutOfBoundsException("The array is empty");
        }

        if (_front.item.equals(object))
        {
            _front = _front.next;
            _size--;
        }
        else
        {
            ListNode<T> prev = _front;
            ListNode<T> curr = _front.next;
            while (curr != null)
            {
                if (curr.item.equals(object))
                {
                    prev.next = curr.next;
                    _size--;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DiivLinkedListIterator();
    }

    private int _size;
    private ListNode<T> _front;

    private class DiivLinkedListIterator implements Iterator<T>
    {
        private ListNode<T> curr;

        public DiivLinkedListIterator()
        {
            curr = _front;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            T value = curr.item;
            curr = curr.next;
            return value;
        }
    }
}
