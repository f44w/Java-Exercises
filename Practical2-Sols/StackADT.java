package practical2;

public interface StackADT<E> {
    public void push(E item);
    public E pop();
    public E getTop();
    public int size();
    public boolean isEmpty();
    public void traverse();
}
