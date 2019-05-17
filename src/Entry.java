import java.util.*;
/**
* This is the Entry clas
*
* @author Amelia Tran
* @version 4/25/2019
*/

public class Entry<K extends Comparable<K>, V, A> 
					implements Comparable<Entry<K,V,A>> {

	// local variables
	private K priority;
	private V time;
	private A age;

	/**
	* The constructor
	* @param pri type K
	* @param t type V
	* @param a type A
	*/
	public Entry(K pri, V t, A a) {
		priority = pri;
		time = t;
		age = a;
	}

	/**
	* The getter method to return the priority 
	* @return K type K
	*/
	public K getPriority() {
		return priority;
	}

	/**
	* The setter method to set the priority 
	* @param newPriority type K
	*/
	public void setPriority(K newPriority) {
		priority = newPriority;
	}

	/**
	* The getter method to return the time
	* @return V type V
	*/
	public V getTime() {
		return time;
	}

	/**
	* The getter method to return the age
	* @return A type A
	*/
	public A getAge() {
		return age;
	}

	/**
	* The setter method to set the age
	* @param newAge type A
	*/
	public void setAge(A newAge) {
		age = newAge;
	}

	/**
	* The compare method to compare the priority 
	* @param obj an Entry
	* @return int 
	*/
	public int compareTo( Entry<K,V,A> obj) {
		if (priority.compareTo(obj.getPriority())>0) {
			return 1;
		} else if (priority.compareTo(obj.getPriority())==0) {			
			return 0;
		} else {
			return -1;
		}
	}

	/**
	* The toString method return the execution time
	* @return String a string
	*/
	public String toString() {
		return time.toString();
	}
}