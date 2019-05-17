import java.io.*;
import java.util.ArrayList; // import the ArrayList class

/**
* This is the Heap 
*
* @author Amelia Tran
* @version 4/25/2019
*/

public class Heap<K extends Comparable<K>, V, A> {

	private ArrayList<Entry<K, V, A>> tree;

	//constructor 
	public Heap() {
		tree = new ArrayList<Entry<K, V, A>>();
	}

	/**
	* The get method that returns data type T at position index
	* @return Entry an entry
	* @param index type int 
	*/
	public Entry<K, V, A> get(int index) {
		return tree.get(index);
	}


	/**
    * The set method that will set the data to specific index
    * @param data a Entry passed in
    * @param index an int
    */
	public void set( int index, Entry<K, V, A> data) {
		tree.set(index, data);
	}

	/**
	* The isEmpty method that returns a boolean telling whether the heap 
	* is empty or not
	* @return true if empty
	*/
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	/**
	* The size method that returns size of the heap
	* @return int 
	*/
	public int size() {
		return tree.size();
	}

	/**
	* The peek method that returns the thing on the top of the heap
	* @return Entry entry 
	*/
	public Entry<K, V, A> peek() {
		return tree.get(0);
	}


	/**
	* The add method that adds data to the tree
	* @param data an entry
	*/
	public void add( Entry<K, V, A> data){
		tree.add(tree.size(), data);
		siftUp(tree.size()-1);
	}

	/**
	* The siftUp method that rearrange the positions of the node
	* after adding
	* @param pos position
	*/
	public void siftUp( int pos) {
		int parent = (pos-1)/2;
		Entry<K, V, A> temp;
		
		// if the parent is smaller than its chidren, swap
		while (parent >= 0 && tree.get(pos).compareTo(tree.get(parent)) > 0) {
			temp = tree.get(parent);
			tree.set(parent,tree.get(pos));
			tree.set(pos,temp);
			// update children and parent
			pos = parent;
			parent = (pos-1)/2;
		}
	}

	/**
	* The remove method that remove data to the tree
	*/
	public void remove() {	
		// set the first node the data of the last	
		tree.set(0, tree.get(size()-1));
		// remove the last node
		tree.remove(size()-1);
		// rearrange
		siftDown(0);
	}

	/**
	* The siftDown method that rearrange the positions of the node
	* after removing
	* @param pos position
	*/
	public void siftDown( int pos) {
		int leftChild = 2*pos +1;
		int rightChild = 2*pos +2;
		int max;
		Entry<K, V, A> temp;
		// check if left child exists
		while (leftChild<size()) {
			// assume the max child is left one
			max = leftChild;
			// check if right child exists
			if (rightChild<size()) {
				// compare two children
				if (tree.get(leftChild).compareTo(tree.get(rightChild)) < 0) {
					// update max if right child is bigger
					max = rightChild;
				}
			}

			// if parent is smaller than max child
			if (tree.get(pos).compareTo(tree.get(max)) < 0) {
				// swap parent with the max child	
				temp = tree.get(max);
				tree.set(max,tree.get(pos));
				tree.set(pos,temp);

				// update the index
				pos = max;
				leftChild = 2*pos +1;
				rightChild = 2*pos +2;
			} else {
				break;
			}
		}
	}	

	/**
	* The toString method that returns a String representation of the heap
	* @return String of the data
	*/
	public String toString() {
		String result = "";
		for (int i = 0; i<tree.size(); i++){
			result = result + tree.get(i).toString() +" ";
		}
		return result;
	}

	/**
	* The main method to test heap
	* @param args of the data
	*/
	public static void main (String[] args) {	
		Heap<Double, Integer, Integer> test = new Heap<>();
		Entry<Double, Integer, Integer> test1 = new Entry<>(3.0, 100, 100); 
		Entry<Double, Integer, Integer> test2 = new Entry<>(3.0, 500, 500); 
		System.out.println( test1.compareTo(test2));

	}
}
