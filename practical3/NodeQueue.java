package practical3;

import java.util.NoSuchElementException;

/**
 * This class is for completion in Practical 3iii
 * The Node class is supplied for you
*/
public class NodeQueue<E> implements QueueADT<E>
{
    // references to the head and tail of 
    // the linked list
    protected Node<E> head, tail;   
    // number of elements in the queue
    protected int size;     

    /** constructs an empty queue
    */
    public NodeQueue() {    
       head = null; tail = null;
       size = 0;
    }
    
   // Complete the method bodies below. Take care
   // that exceptions of the correct types are thrown by 
   // your methods as specified in the method comments.
   
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void enqueue(E elem) {
    // create and link in a new node at tail
        Node<E> newNode = new Node<>(elem, null);
        if(isEmpty()){
        // Front and rear are on the same/only node
            head = tail = newNode;
        }else{
            // set rear to next element:
            tail.setNext(newNode);
            tail = newNode;
        }
        // Increment size:
        size++;
    }

    /**
     @throws EmptyQueueException
    */
    public E front() {
        if (isEmpty()) {
            throw new EmptyQueueException("Empty Queue! No front element!");
        }
        return head.getElement();
    }

    /**
     @throws EmptyQueueException
    */
    public E dequeue() {
        if(isEmpty()){
            // Empty queue, throw exception:
            throw new EmptyQueueException("Empty Queue! Nothing to dequeue!");
        }else{
            // Get current head element to return
            E element = head.getElement();
            // Move head to next Node
            head = head.getNext();
            // Dec size
            size--;
            return element;
        }

    }
}
