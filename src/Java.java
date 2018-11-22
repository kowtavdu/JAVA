import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class MyConsumer implements Consumer<Integer>{
	@Override
	public void accept(Integer t) {
		// TODO Auto-generated method stub
		System.out.println("printing value of consumer "+t);
	}
}
public class Java {

	public static void main(String args[]){
		System.out.println("Hello i am here...");
		List <Integer>lst = new ArrayList<Integer>();
		for(Integer i=1; i<20;i++){
			lst.add(i);
		}
		System.out.println("Print the list "+lst);
        //Iterating using iterator
		Iterator<Integer> it = lst.iterator();
	    while(it.hasNext()){
	    	Integer i = (Integer) it.next();
	    	System.out.println("Printing list using iterator "+i);
	    }
	    //printing values using foreach
	    MyConsumer action = new MyConsumer();
	    lst.forEach(action);
	    
	    //implement foreach for anonymous class
	    lst.forEach(new Consumer<Integer>(){

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("Print from ananymous class "+t);
			}

	    });
	}
}
