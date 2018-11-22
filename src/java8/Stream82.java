package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class Person{
	Person(String name, Integer age){
		this.age = age;
		this.name = name;
	}
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	Integer age;
	
	@Override
	public String toString(){
		return name;
	}

}


public class Stream82 {

	public static void main(String[] args) {
		List<Person> ll = new ArrayList();
		ll.add(new Person("Max", 18));
		ll.add(new Person("Peter", 23));
		ll.add(new Person("Pamela", 23));
		ll.add(new Person("David", 12));
		
		ll = ll.stream()
		.filter(p -> p.name.startsWith("P"))
		.collect(Collectors.toList());
		
		System.out.println(ll);
		
	}
}
