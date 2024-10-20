package practical1;

import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E> {
    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 5;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }


    // constructor with specific capacity
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
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

    private void resize(int newCapacity) {
        // Initialize new array of type E named "tmp"
        // Casting our new object with size of newCapacity
        E[] temp = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    @Override
    public void insert(int i, E x) {
        try {
            // Check if size is the same as the length of our array
            if (size == data.length) {
                // Multiply original length by 2 and pass into method
                resize(data.length * 2);
                //throw new FullListException("List is full!");
            }
            // if (i < 0 || (i > (size))) {
            // throw new IndexOutOfBoundsException();
            //}
            for (int j = size - 1; j > i; j--) { // Shift elements up
                data[j + 1] = data[j]; // To make room
            }
            data[i] = x;
            size++; // Increment list length
            System.out.println("Element inserted!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds!");
        }
    }

    public E delete(int index) {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            if (size == 0) throw new EmptyListException("The list is empty now!");
            E removedElement = data[index];
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
                size--;
                return removedElement;
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index out of bounds!");
        }
        return null;
    }

    public void display() {
        if (size == 0) {
            System.out.print("The list is empty now, no elements to be displayed!");
        }
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " \n");
        }
    }

    public int search(E x) {
        if(size==0){
            throw new NoSuchElementException();
        }
        for(int i=0; i<size; i++){
            if(data[i].equals(x)){
                return i;
            }
        }
        return -1;
    }
}
