import java.util.*;
/**
* This is the Priority Queue 
*
* @author Amelia Tran
* @version 4/25/2019
*/

public class PriorityQueue<K extends Comparable<K>, V, A> {
	private Heap<K, V, A> theData;

	// constructor
	public PriorityQueue() {
		theData = new Heap<K, V, A>();
	}

	/**
	* The setter method that rearranges the possitions of the node
	* @param pos position
	*/
	public void siftDown( int pos) {
		theData.siftDown(pos);
	}

	/**
    * The add method that will add the object on the top of the queue.
    * @param obj an Entry passed in
    */
	public void add(Entry<K, V, A> obj){
		theData.add(obj);
	}

	/**
    * The set method that will set the object to specific position
    * @param obj a T variable passed in
    * @param index integer
    */
	public void set(int index, Entry<K, V, A> obj){
		theData.set(index, obj);
	}

	/**
	* The remove method that removes the thing on the top of the queue
	* @return Entry entry 
	*/
	public Entry<K, V, A> remove(){
		if (isEmpty()){
			return null;
		} else {
			Entry<K, V, A> temp = theData.get(0);
			theData.remove();
			return temp;
		}
	}

	/**
	* The isEmpty method that returns a boolean telling whether the queue is empty or not
	* @return true if empty
	*/
	public boolean isEmpty(){
		return theData.isEmpty();
	}

	/**
	* The peek method that returns the thing on the top of the queue
	* @return Entry 
	*/
	public Entry<K, V, A> peek() {
		return theData.peek();
	}

	/**
	* The size method that returns size of the queue
	* @return int
	*/
	public int size() {
		return theData.size();
	}

	/**
	* The get method that returns data type T at position index
	* @return Entry an entry
	* @param index type int
	*/
	public Entry<K, V, A> get(int index) {
		return theData.get(index);
	}

	/**
	* The toString method that returns a String representation of the stack
	* @return String of the data
	*/
	public String toString(){
		return theData.toString();
	}

	/**
	* The main method to test heap
	* @param args of the data
	*/
	public static void main (String[] args) {	
		PriorityQueue<Double, Integer, Integer> test = new PriorityQueue<>();

		Entry<Double, Integer, Integer> test1 = new Entry<>(400.0, 400, 100); 
		Entry<Double, Integer, Integer> test2 = new Entry<>(35.0, 35, 500); 
		Entry<Double, Integer, Integer> test3 = new Entry<>(12.0, 12, 500);
		Entry<Double, Integer, Integer> test4 = new Entry<>(250.0, 250, 500);
		Entry<Double, Integer, Integer> test5 = new Entry<>(1000.0, 1000, 500);
		Entry<Double, Integer, Integer> test6 = new Entry<>(600.0, 600, 500);
		Entry<Double, Integer, Integer> test7 = new Entry<>(75.0, 75, 500);
		Entry<Double, Integer, Integer> test8 = new Entry<>(378.0, 378, 500);
		Entry<Double, Integer, Integer> test9 = new Entry<>(957.0, 957, 500);
		test.add(test1);
		test.add(test2);
		test.add(test3);
		test.add(test4);
		test.add(test5);
		test.add(test6);
		test.add(test7);
		test.add(test8);
		test.add(test9);

		System.out.println(test.toString());

	}
}



	
	