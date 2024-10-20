package practical1;

// Define a generic interface for the List ADT
public interface ListADT<E>{
    public boolean isEmpty();
    public int size();
    public E get(int index);
    public void set(int index, E element);
    public void insert(int index, E element);
    public E delete(int index);
    public void display();
    public int search(E element);
    public void expandCapacity();
}
