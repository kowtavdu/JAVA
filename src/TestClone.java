import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Add  implements Cloneable{
	Add(String city, String zipcode){
		this.city = city;
		this.zipcode = zipcode;
	}
	String city;
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
	String zipcode;	
}

class MyClonePerson implements Cloneable{
	
	/*MyClonePerson(MyClonePerson obj){
		this.id = obj.id;
		this.add = obj.add;
		this.name = obj.name;
		this.salary = obj.salary;
	}*/
	
	
	public Add add;
	MyClonePerson(int id, String name, int salary, Add add){
		this.id = id;
		this.add = add;
		this.name = name;
		this.salary = salary;
	}
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Add getAdd() {
		return add;
	}
	public void setAdd(Add add) {
		this.add = add;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private String name;
	private int salary;
	

	@Override
	public Object clone() throws CloneNotSupportedException
    {
		MyClonePerson p = (MyClonePerson)super.clone();
	    return p;	
    }
	
	
	/*public Object Clone() throws CloneNotSupportedException{
		//MyClonePerson p = (MyClonePerson)super.clone();
		MyClonePerson p = new MyClonePerson(this.id, this.name, this.salary);
		return p;
		return super.clone();
	}*/
	
	public String toString(){
		return "[ Id: "+id +", name: "+name+",Salary: "+salary+"]";
	}
}


public class TestClone {

	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		Add ad = new Add("gwl","474005");
		MyClonePerson p1 = new MyClonePerson(1,"AA",200, ad);
		//MyClonePerson p2 = (MyClonePerson)p1.clone();
		/*MyClonePerson p2 = new MyClonePerson(p1);
		p2.setName("BBB");
		p2.add.setCity("Mor");
		if(p1 == p2){
			System.out.println("same reference");
		}else{
			System.out.println("different reference");
		}
		System.out.println(p1.getName() +"---------- "+p2.getName());
		System.out.println(p1.add.getCity() +"---------- "+p2.add.getCity());*/
		
		FileOutputStream fout = new FileOutputStream("test.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(p1);
		fout.close();
		oos.close();
		FileInputStream fis = new FileInputStream("test.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		MyClonePerson p3 = (MyClonePerson) ois.readObject();
		p3.add.setCity("Bhopal");
		fis.close();
		ois.close();
		System.out.println(p1.add.city +" ====== "+p3.add.city);
		
		/*try {
		MyClonePerson p1 = new MyClonePerson(1,"AA",200);
		MyClonePerson p2 = (MyClonePerson) p1.Clone();
		p2.setName("BBB");
		System.out.println(p1.getName()+"-------"+p2.getName());
		p2.setSalary(300);
		System.out.println("p1 => "+p1.getSalary());
		System.out.println("p2 => "+p2.getSalary());
		if(p1==p2){
			System.out.println("Same Object");
		}else{
			System.out.println("Different Object");
		}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
