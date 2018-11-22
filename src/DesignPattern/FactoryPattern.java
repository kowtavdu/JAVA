package DesignPattern;

abstract class Employee{
	public abstract int getEmployeeId();
	public abstract String getName();
	public abstract String getType();
	
	public String toString(){
		return "["+getEmployeeId()+" --- "+getName()+"----"+ getType()+"]";
	}
}

class Developer extends Employee{
    int employeeId;
    public String getEmployeeName() {
		return employeeName;
	}
	
    public String getEmployeeType() {
		return employeeType;
	}
	
	String employeeName;
    String employeeType;
    
    Developer(int employeeId, String employeeName, String employeeType){
    	this.employeeId = employeeId;
    	this.employeeName = employeeName;
    	this.employeeType = employeeType;
    }
	@Override
	public int getEmployeeId() {
		// TODO Auto-generated method stub
		return employeeId;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return employeeName;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Development Domain "+employeeType;
	}
	
}

class Tester extends Employee{
	int employeeId;
	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	String employeeName;
	String employeeType;
	
	Tester(int employeeId, String employeeName, String employeeType){
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeType = employeeType;
	}

	@Override
	public int getEmployeeId() {
		// TODO Auto-generated method stub
		return employeeId;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return employeeName;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Testing Domain "+employeeType;
	}
	
}

class EmployeeFactory{
	public static Employee createEmployess(String empType, Integer EmpId, String EmpName){
		if(empType.equals("dev")) return new Developer(EmpId, EmpName, empType);
		else if(empType.equals("test")) return new Tester(EmpId, EmpName, empType);
		else return null;	
		
	}
}

public class FactoryPattern {
   public static void main(String[] args) {
	   
	  Employee e1 = EmployeeFactory.createEmployess("dev", 38967, "saurabh");
	  Employee e2 = EmployeeFactory.createEmployess("test", 36967, "anjali");
	  System.out.println("-------e1------"+e1);
	  System.out.println("-------e2------"+e2);
   }    	
}
