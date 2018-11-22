package scjp;

class Diwali{
	public void HappyDiwali(){
		System.out.println("Diwali is Festival");
	}
	
	/*public void Hi(){
		System.out.println("Diwali HI");
	}*/
}

class Ocassion extends Diwali{
	public void Session(){
		System.out.println("Ocassional greeting");
	}
	
	private void Hi(){
		System.out.println("Ocassion HI");
	}

	
}

class TestOver {

	public static void main(String args[]){
		System.out.println("HI I am Here");
		
		/*Ocassion occ = new Ocassion();
		Object obj = occ;
		Diwali d = (Diwali) obj;
		TestOverService tos = (TestOverService) obj;
		
     	tos.greet();*/
	    /*Diwali d = new Ocassion();
	    d.Hi();
	    Diwali s = new Diwali();
	    s.Hi();*/
	}
}
