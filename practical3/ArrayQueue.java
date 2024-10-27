package practical3;
/**
 * This class is for completion in practical 3 part i
*/
public class ArrayQueue<E> implements QueueADT<E>
{
   protected E[] Q; // Q will refer to the array
   protected int f; // front - array index of element at front of queue
   protected int r; // rear - array index of where next element added will be placed 
   protected int N;  // array capacity

   /**
    * Constructor for objects of class ArrayQueue.
    * In practical 3i no change need be made to this constructor.
    * With this constructor a queue can hold up to 3 (i.e.N-1) items when 
    * using the approach described in lectures.
    */
   public ArrayQueue()
   {
       N=4;
       Q = (E[]) new Object[N];
       f=0;
       r=0;
   }

   /**
     @throws FullQueueException
   */
   public void enqueue(E element){
      // Need final "index" to be for rear only:
      if(size() == N-1){
         throw new FullQueueException("Queue is full! Cannot enqueue!");
      }
      else{
         // Add element to the rear:
         Q[r] = element;
         // Modulo to wrap back around if at final element of the array
         r = (r+1)%N;
      }
   }

   /**
     @throws EmptyQueueException
   */
   public E dequeue(){
      // If front and rear are same, same index:
      if (f==r){
         throw new EmptyQueueException("Queue is empty! Nothing to dequeue!");
      }else{
         // Remove element from front & set new front:
         E element = Q[f];
         // % for wrapping around if we are at end index:
         f = (f+1)%N;
         return element;
      }
   }

   /**
    @throws EmptyQueueException
    */
   public E front(){
      // If queue is empty:
      if (r == f)
         throw new EmptyQueueException("The queue is empty");
      return Q[f];
   }

   public int size(){
      // Returns number of elements currently in queue, not capacity
      // When size is non-neg, +N doesn't change result as % cancels it
      // if neg, +N wraps index around, %N then gives correct size
      return(r-f+N)%N;
   }

   public boolean isEmpty(){
      return (f == r);
   }  
}
