interface abs{
	public abstract void Greet();
}
interface abs2{
	public abstract void Greet();
}

class Hi implements abs ,abs2 {
	
	public void Greet(){
		System.out.println("CALLED IN TEST METHOD");
	}
}
public class MultipleInheritance {

	public static void main(String args[]){
		System.out.println("HI I am here...");
		abs hi = new Hi();
		hi.Greet();
		System.out.println("<------------>");
		abs2 h2 = new Hi();
		h2.Greet();
	}
}
 