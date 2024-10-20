package practical1;

import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E>{
    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 5;

    // No-argument constructor
    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }

    // constructor with specific capacity
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 0) throw new EmptyListException("The list is empty now!");
        return data[index];
    }

    @Override
    public void set(int i, E x) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[i] = x;
    }

    @Override
    public void insert(int i, E x) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == DEFAULT_CAPACITY) {
            expandCapacity();//throw new FullListException("The list is full now");
        }
        for (int j = size - 1; j >= i; j--) {
            data[j + 1] = data[j];
        }
        data[i] = x;
        size++;
    }

    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 0) throw new EmptyListException("The list is empty now!");
        E removedElement = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size --;
        return removedElement;
    }

    public void display(){
        if (size == 0) {
            System.out.print("The list is empty now, no elements to be displayed!");
        }
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " \n");
        }
    }

    public int search(E x){
        if (size == 0) throw new EmptyListException("The list is empty now!");
        for (int i = 0; i < size; i++)
            if (data[i].equals(x)) {
                return i;
            }
        return -1;
    }
    @SuppressWarnings("unchecked")
    public void expandCapacity() {
        E[] largerData = (E[]) new Object[size * 2];
        System.arraycopy(data, 0, largerData, 0, size);
        data = largerData;
    }
}
