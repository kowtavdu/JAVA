package dp;


class Address implements Cloneable{
	Address(String add1, String city, String zipcode){
		this.add1 = add1;
		this.city = city;
		this.zipcode = zipcode;
	}
	String add1;
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	String city;
	String zipcode;
}
class Employee implements Cloneable{
	
	Employee(String name, String phone, Address address){
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	String phone;
	Address address;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Employee emp = (Employee)super.clone();
		emp.address = (Address) address.clone();
	    return emp;	
	}
}


public class ProtoD {

	public static void main(String[] args) throws CloneNotSupportedException {
	
		Employee emp1 = new Employee("saurabh","9540052570", new Address("Indermani","Gwalior","474005"));
		Employee emp2 = (Employee) emp1.clone();
		emp2.setName("Gaurabh");
		emp2.address.setAdd1("Thatipur");
		
		System.out.println(emp2.getName()+"--------- "+emp1.getName());
		System.out.println(emp2.getAddress().getAdd1()+"--------- "+emp1.getAddress().getAdd1());
		
		
		
		
	}
}
