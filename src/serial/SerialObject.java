package serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ReadOnlyBufferException;

class Address implements Cloneable{
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	Address(String add, String pincode){
		this.address1 = add;
		this.pincode = pincode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String address1;
	public String pincode;
	
	
}


class Student implements Cloneable {
	Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/*private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(mobileNumber);
    }

    *//**
     * Private method, same signature as in Serializable interface
     *
     * @param stream
     * @throws CloneNotSupportedException 
     * @throws IOException
     *//*
    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        mobileNumber = (String) stream.readObject();

    }*/
	
	public Object Clone() throws CloneNotSupportedException{
		//return super.clone();
		Student st = (Student) super.clone();
		st.address = (Address) address.clone();
		return st;
	}

	Student(int rollNo, String fName, String lName, int age, String mobileNo, Address add){
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.rollNumber = rollNo;
		this.mobileNumber = mobileNo;
		this.address = add;
	}
	
	int rollNumber;
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	String firstName;
	String lastName;
	int age;
	String mobileNumber;
}
	
public class SerialObject {

	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
		Address add1 = new Address("Gwalior ","474005");
		Student st2 = new Student(89, "saurabh", "singh", 32, "9540052570", add1);
		
		Student st1 = (Student) st2.Clone();
		String add2 = st1.address.address1;
		st1.address.address1 = "Morena";
		//Address add2 = st1.address;
		System.out.println(st1.firstName+"----"+st1.lastName+"------"+st1.age+"-----"+st1.rollNumber+"----"+st1.mobileNumber+"-------"+add2);
		System.out.println(st2.firstName+"----"+st2.lastName+"------"+st2.age+"-----"+st2.rollNumber+"----"+st2.mobileNumber+"-------"+st2.address.address1);
		
		/*FileOutputStream fo = new FileOutputStream("Student.ser");
		ObjectOutputStream os = new ObjectOutputStream(fo);
		os.writeObject(add);
		os.flush();
		os.close();
		fo.close();
		System.out.println("wrtie has been done successfully");
		
		FileInputStream fis = new FileInputStream("Student.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student st1 = (Student) ois.readObject();
		//Address ad = (Address)st1;
		System.out.println(st1.firstName+"----"+st1.lastName+"------"+st1.age+"-----"+st1.rollNumber+"----"+st1.mobileNumber+"-------");
		fis.close();*/
	}
}
