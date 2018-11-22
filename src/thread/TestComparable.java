package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CompStudent implements Comparable{
	CompStudent(){}
	CompStudent(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setSalary(int age) {
		this.age = age;
	}
	private String name;
	private int age;
	
	public String toString(){
		return "[name: "+name+", Age: "+age+"]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		CompStudent t = (CompStudent) o;
		if(this.age>t.age) return 1;
		else if(this.age<t.age) return -1;
		return 0;
	}
}

public class TestComparable {

	public static void main(String[] args) {
		
		CompStudent t = new CompStudent(1, "saurabh", 34);
		CompStudent t3 = new CompStudent(1, "Gaurav", 32);
		CompStudent t1 = new CompStudent(1, "Abhishek", 38);
		List<CompStudent> myList = new ArrayList<>();
		myList.add(t);
		myList.add(t1);
		myList.add(t3);
		System.out.println(myList);
		Collections.sort(myList);
		System.out.println(myList);
	}
}
