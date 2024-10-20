package practical2;

import java.util.Stack;

public class LinkedStack<E> implements StackADT<E> {
    protected Node<E> top;
    protected int size;
    public LinkedStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(E item){
        Node<E> v = new Node<>(item,top);
        top = v;
        size++;
    }

    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException("The stack is empty. No elements to return!");
        }
        E itemRemoved = top.getElement();
        top = top.getNext();
        size--;
        return itemRemoved;
    }

    public E getTop() {
        return top.getElement();
    }

    @Override
    public void traverse() {
        if (isEmpty()) {
            throw new EmptyStackException("The stack is empty. No elements can be traversed!");
        }
        Node<E> temp = top;
        System.out.println("Stack elements from top to bottom:");
        while (temp != null) {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        }
    }
}
