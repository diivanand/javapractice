package diiv.javapractice.util.collections;


public class DiivBinaryHeapPriorityQueue<T extends Comparable> implements DiivPriorityQueue<T> {
    public DiivBinaryHeapPriorityQueue() {
        _binHeap = new BinaryHeap<T>(DEFAULT_CAPACITY);
    }

    public DiivBinaryHeapPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be a positive integer");
        }
        _binHeap = new BinaryHeap<T>(capacity);
    }

    @Override
    public void enqueue(T obj) {
        _binHeap.insert(obj);
    }

    @Override
    public T dequeue() {
        return _binHeap.remove();
    }

    @Override
    public T front()
    {
        return _binHeap.topOfHeap();
    }

    @Override
    public int size() {
        return _binHeap.size();
    }

    @Override
    public T getMin() {
        return _binHeap.topOfHeap();
    }

    private BinaryHeap<T> _binHeap;
    private final int DEFAULT_CAPACITY = 5;

    private class BinaryHeap<T extends Comparable> {
        public BinaryHeap(int capacity) {
            _capacity = capacity;
            _arr = (T[]) new Object[_capacity];
            _size = 0;
        }

        public int size()
        {
            return _size;
        }

        public void insert(T obj) {
            if (_size == _capacity) {
                throw new IllegalArgumentException("Heap is full!");
            }

            _size++;
        }

        public T remove() {
            if (_size == 0) {
                throw new IllegalArgumentException("Heap is empty!");
            }
            _size--;
            return null;
        }

        public T topOfHeap() {
            if (_size == 0) {
                throw new IllegalArgumentException("Heap is empty!");
            }
            return _arr[0];
        }

        private int parentIndex(int currIndex) {
            return currIndex / 2;
        }

        private int leftChildIndex(int currIndex) {
            return currIndex * 2;
        }

        private int rightChildIndex(int currIndex) {
            return currIndex * 2 + 1;
        }

        private void bubbleUp(int currIndex) {

        }

        private void swap(int index1, int index2) {

        }

        private T[] _arr;
        private int _size;
        private int _capacity;
    }
}
