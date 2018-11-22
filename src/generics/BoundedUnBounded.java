package generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Animal extends Bird{
	
}

class Cat extends Animal{
	
}
class Dog extends Animal {
	
}

class Bird{
	
}


public class BoundedUnBounded {

	public static void main(String[] args) {
	
		//Bounded type in generic
		ArrayList<? extends Animal> myList2 = new ArrayList();
		ArrayList <Animal>myList = new ArrayList();
		myList.add(new Animal());
		myList.add(new Cat());
		myList.add(new Dog());
		
		//myList.add("ssss");
		myList2 = new ArrayList<Animal>();
		myList2 = myList;
		myList2 = new ArrayList<Dog>();
		myList2 = new ArrayList<Cat>();
		
		ArrayList<? super Animal> myList3 = new ArrayList();
		myList3 = new ArrayList<Bird>();
		myList3 = new ArrayList<Animal>();
		//-------RULES and Examples of generic in JAVA--------------------------------------------------
		List myList4 = new ArrayList<Integer>();
		myList4 = new ArrayList<String>();
		
		List<Object> myList5 = new ArrayList<Object>();
		myList5.add("abn");
		myList5.add(123);
		
		//unBounded type in generic 
		List<?> myList6 = new ArrayList<String>();
		myList6 = new ArrayList<Integer>();
		myList6 = new ArrayList<Bird>();
		
		List<String> myList7 = new ArrayList<String>();
		myList7 = new LinkedList<String>();
		
		
		
	}
}
