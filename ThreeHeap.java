//Max Tran, CSE 373 Winter 2017, HW#2
/*This class implements a priority queue ADT through the use 
of a three heap. A three heap node can have up to 3 children 
nodes and is represented by an array. It will behave like a
normal priority queue which return the element based on its 
priority (lower value = higher priority). Thus the higher 
priority elements are returned first and when they were inserted
won't affect it. Duplicates are allowed.*/
import java.util.List;

public class ThreeHeap implements PriorityQueue {
	//the default size of the priority queue
   private final int DEFAULT_CAPACITY = 10; 
	private double[] heap; //array representation of the three heap
	private int size; //the number of elements in the three heap
   
   //constructs the priority queue ADT  
   //that sorts its elements in a way similar 
   //to heap order property and has a structure of 
   //a complete trinary tree
	public ThreeHeap(){
		heap = new double[DEFAULT_CAPACITY];
		size = 0;	
	}
   
   //construct a priority queue ADT with a given capacity
   public ThreeHeap(int capacity){
      heap = new double[DEFAULT_CAPACITY];
      size = 0;
   }
   
   /*Empty the three heap then add all the elements
   from the list to the three heap then doing a pass for 
   swapping using Floyd's method*/  
   public void buildQueue(List<Double> list){
      makeEmpty();
      insertAll(list);
      for(int index = (size+1)/3; index > 0;index--){
         double value = heap[index];
         int hole = percolateDown(index, value);
         heap[hole] = value;         
      }
   }
   
   //returns true if the three heap has no elements
	public boolean isEmpty() {
		return size()==0;
	}
   
   //return the quantity of element the three heap contains
	public int size() {
		return size;
	}
   
   /*throw EmptyHeapException if the three heap is empty
   return the mimimum number of the queue 
   which is at index 1*/   
	public double findMin() {
		if (isEmpty()) {
			throw new EmptyHeapException("ThreeHeap is empty");
		}	
		return heap[1];
	}
   
   //inserts element x into the three heap 
   //allows duplicate values
	public void insert(double x) {
		if(size >= heap.length-1){
         increaseCapacity();
      }
      size++;
      int index = percolateUp(size, x);
      heap[index] = x;
	}
   
   //delete and return the mimimum element 
   //from the three heap
	public double deleteMin() {
		if (isEmpty()) {
			throw new EmptyHeapException("ThreeHeap is empty");
		}	
		double minValue = findMin();
      int hole = percolateDown(1, heap[size]);
      heap[hole] = heap[size];
	   size--;
		return minValue;
	}
   
   //remove all the element from the three heap 
	public void makeEmpty() {
		heap = new double[DEFAULT_CAPACITY];
		size =0;
	}
	
   //return a string representation of the three heap
	public String toString(){
      String answer = "";
      int height = 1;
      for(int index = 1; index <= size;index++){
         answer += heap[index] + " ";
         if((index-1)%3==0){
            answer += " || ";
         }
         if(index ==((int)Math.pow(3,height)) /2){
            answer += "\n";
            height++;
         }
      }
      return answer;      
	}
	
   //restores heap order property upon insertion of element
   //by percolating a node up the three-heap,
	private int percolateUp(int hole, double val){
      while(val < heap[(hole+1)/3] && hole > 1){
         heap[hole]=heap[(hole+1)/3];
         hole = (hole+1)/3;
      }
		return hole;
	}
	
   //restores heap order property upon deletion of minimum element
   //by percolating a node down the three-heap
	private int percolateDown(int hole, double val){
      int target;
      int leftIndex;
      int midIndex;
      int rightIndex;
      while(size >= 3*hole-1){
         leftIndex = 3*hole - 1;
         rightIndex = 3*hole + 1;
         midIndex = 3*hole;
         target = leftIndex;
         if(size >= midIndex &&(heap[midIndex] < heap[target])){
            target = midIndex;
         }
         if (size >= rightIndex && (heap[rightIndex] < heap[target])){
            target = rightIndex;
         }
         if (heap[target] < val){
            heap[hole] = heap[target];
            hole = target;
         } else {
            break;
         }
      }
		return hole;
	}
   
   /*a private method to insert all the element into
   the priority queue to help the buildQueue method
   performing the Floyd's method*/
   private void insertAll(List<Double> list){
      for(int i = 1; i <list.size();i++){
         if(i==heap.length-1){
            increaseCapacity();
         }
         heap[i]=list.get(i);
         size++;
      }
   }
   
   /*a private method to help increase the capacity of the
   three heap when the priority queue is full*/
   private void increaseCapacity(){
      double[] biggerHeap = new double[heap.length*2];
      for(int i = 0; i <= size; i++){
         biggerHeap[i] = heap[i];   
      }
      heap = biggerHeap;
   }
}
