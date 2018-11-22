package serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class MySerial implements Serializable{
	
	
	MySerial(String n, String rating){
		this.name = n;
		this.rating = rating;
	}
	transient public String name;
	public String rating;
	
	
	
	/*private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(name);
    }
	
	private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        name = (String) stream.readObject();

    }*/
	 
	
	private void writeObject(ObjectOutputStream stream) throws IOException {
	        stream.defaultWriteObject();
	        stream.writeObject(name);
	    }
	
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException{
		stream.defaultReadObject();
		name = (String) stream.readObject();
	}
	
	 @Override
	    public String toString() {
	        return "SerializationTest{" +
	                "firstData='" + name + '\'' +
	                ", secondData='" + rating + '\'' +
	                '}';
	    }
	
}


public class TestSerial {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		
		FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("object.out");
            oos = new ObjectOutputStream(fos);
            MySerial sTest = new MySerial("Chandrakanta", "5.0");
            oos.writeObject(sTest);
        } finally {
            oos.close();
            fos.close();
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("object.out");
            ois = new ObjectInputStream(fis);
            MySerial sTest = (MySerial) ois.readObject();
            System.out.println(sTest);
        } finally {
            ois.close();
            fis.close();
        }
		
	}
}
