package diiv.javapractice.util.collections;


public class DiivArrayStack<T> implements DiivStack<T> {
    public DiivArrayStack()
    {
        _capacity = DEFAULT_CAPACITY;
        commonConstructorSetting();
    }

    public DiivArrayStack(int capacity)
    {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be a positive integer");
        }
        _capacity = capacity;
        commonConstructorSetting();
    }

    private void commonConstructorSetting() {
        _topOfStackIndex = -1;
        _arr = (T[]) new Object[_capacity];
    }

    @Override
    public void push(T obj) {
        if (_topOfStackIndex == _capacity) {
            throw new IllegalArgumentException("Stack is full. Cannot push.");
        }
        _topOfStackIndex++;
        _arr[_topOfStackIndex] = obj;
    }

    @Override
    public T pop() {
        if (_topOfStackIndex == -1) {
            throw new IllegalArgumentException("Stack is empty. Nothing at top of stack");
        }
        T item = _arr[_topOfStackIndex];
        _topOfStackIndex--;
        return item;
    }

    @Override
    public T peek() {
        if (_topOfStackIndex == -1) {
            throw new IllegalArgumentException("Stack is empty. Nothing at top of stack");
        }
        return _arr[_topOfStackIndex];
    }

    @Override
    public int size() {
        return _topOfStackIndex+1;
    }

    private T[] _arr;
    private int _topOfStackIndex;
    private int _capacity;
    private final int DEFAULT_CAPACITY = 5;
}
