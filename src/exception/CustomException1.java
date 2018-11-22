package exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

class InvalidAgeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAgeException(String msg){
	 super(msg);
	}
	
	
}
public class CustomException1 {

	static public void checkAge(Integer age) throws InvalidAgeException{
    	if(age<30){
    		throw new InvalidAgeException("Age is Less than 30 unable to vote");	
    	}
    	 
    }	
	public static void main(String args[]){
		System.out.println("Hi I  am Here......");
		//checkAge(50);
		
		int a = 50;
		
		FileReader file;
		try {
			file = new FileReader("C:\\test\\a.txt");
			BufferedReader fileInput = new BufferedReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		/*try{
			//int divident = a/0;
			a.asInstanceOf[String]
		}catch(NoSuchMethodException e){
			e.printStackTrace();
		}*/
		
		
	}
}
