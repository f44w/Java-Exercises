package practical3;


// This class is for completion in Practical 3ii
public class ExtendableArrayQueue<E> implements QueueADT<E>
{
   protected E[] Q; // Q will refer to the array
   protected int f; // front - array index of element at front of queue
   protected int r; // rear - array index of where next element added will be placed 
   protected int N;  // array capacity


    // Constructor for objects of class ExtendableArrayQueue.
    //In practical 3ii no change need be made to this constructor.
    //With this constructor a queue can initially hold up to
    //3 (i.e.N-1) items when using the approach described in lectures.

   public ExtendableArrayQueue()
   {
       N=4;
       Q = (E[]) new Object[N]; 
       f=0;
       r=0;
   }
   
   // Complete the method bodies below and add any further methods if 
   // appropriate. Many of the method bodies can be the same as in Q3i
   
   public void enqueue(E element){
      if(size() == N-1){
         throw new FullQueueException("Queue is full!");
      }else{
         Q[r] = element;
         r = (r+1)%N;
      }
   }
   

  //   @throws EmptyQueueException

   public E dequeue(){
      if(f==r){
         throw new EmptyQueueException("Queue is empty!");
      }else{
         E elementRemoved = Q[f];
         f = (f+1)%N;
         return elementRemoved;
      }

   }
   

   //  @throws EmptyQueueException

   public E front(){
      if (r == f)
         throw new EmptyQueueException("The queue is empty");
      else
         return Q[f];
   }

   public int size(){
      return N;
   }

   public boolean isEmpty(){
      return f == r;
   }

   public void extendCapacity() {
      // New queue object with 2x capacity:
      Q = (E[]) new Object[N*2];
      if(f <= r){
      }
   }
   private void arraycopy(E Q, int front, int rear, E newQ, int index, int size){
      for(int i=0; i<index;i++){

      }
   }
}
