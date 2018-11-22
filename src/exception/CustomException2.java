package exception;

class InvalidAgeExp extends RuntimeException {
	
	InvalidAgeExp(String msg){
		super(msg);
	}
}


public class CustomException2 {


	public static void checkValidAge(int age){
		if(age<14){
			throw new InvalidAgeExp("Invalid Age Exception");
		}
	}
	public static void main(String[] args) {
	
		checkValidAge(12);
		System.out.println("Hello Saurabh");
		
	}
}
