package DesignPattern;

import java.util.ArrayList;
import java.util.List;

class Employee1 implements Cloneable{
	
private List<String> empList;
	
	public Employee1(){
		empList = new ArrayList<String>();
	}
	
	public Employee1(List<String> list){
		this.empList=list;
	}
	public void loadData(){
		//read all employees from database and put into the list
		empList.add("Pankaj");
		empList.add("Raj");
		empList.add("David");
		empList.add("Lisa");
	}
	
	public List<String> getEmpList() {
		return empList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
			List<String> temp = new ArrayList<String>();
			for(String s : this.getEmpList()){
				temp.add(s);
			}
			return new Employee1(temp);
	}
}

public class Prototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee1 emps = new Employee1();
		emps.loadData();
		
		//Use the clone method to get the Employee object
		Employee1 empsNew = (Employee1) emps.clone();
		Employee1 empsNew1 = (Employee1) emps.clone();
		List<String> list = empsNew.getEmpList();
		list.add("John");
		List<String> list1 = empsNew1.getEmpList();
		list1.remove("Pankaj");
		
		System.out.println("emps List: "+emps.getEmpList());
		System.out.println("empsNew List: "+list);
		System.out.println("empsNew1 List: "+list1);
	}
	    
	}

