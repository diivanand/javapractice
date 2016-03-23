package diiv.javapractice.util.collections;

/**
 * Created by diivanand on 3/22/16.
 */
class ListNode<T> {
    public T item;
    public ListNode<T> next;

    public ListNode(T item, ListNode<T> next)
    {
        this.item = item;
        this.next = next;
    }

}
