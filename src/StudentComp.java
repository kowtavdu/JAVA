import java.util.HashMap;
import java.util.Map;

class Employee {
	private String item;
    private int price;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int hashCode(){
        System.out.println("In hashcode");
        int hashcode = 27;
        hashcode += price;
        hashcode += item.hashCode();
        return hashcode;
    }
     
    public boolean equals(Object obj){
        System.out.println("In equals");
        if((obj == null) || obj.getClass() !=this.getClass()){
        	System.out.println("SSSSSSSS22222");
			return false; 
        }	
		if (this == obj)
			return true;
        if (obj instanceof Employee) {
        	Employee pp = (Employee) obj;
            System.out.println("SSSSSSSS1111"+(pp.item.equals(this.item) && pp.price == this.price));
            return (pp.item.equals(this.item) && pp.price == this.price);
        } else {
        	System.out.println("SSSSSSSS");
            return false;
        }
    }
    public String toString(){
        return "item: "+item+"  price: "+price;
    }
}


public class StudentComp {

	public static boolean CheckDuplicateKey(Map p, Integer k, String v){
		if (p.containsKey(k)){
			System.out.println("Key Already contains in Map" );
			return false;	
		}else{
		   p.put(k, v);
		   return true;
		}
		
		
	}
	public static void main(String args[]){
		System.out.println("HI I am here......" );
		Map mp = new HashMap();
		CheckDuplicateKey(mp, 1, "Saurabh");
		CheckDuplicateKey(mp, 1, "Priyanka");
		System.out.println("######### "+mp.get(1));
		/*HashSet<Price> lhm = new HashSet<Price>();
	       lhm.add(new Price("Banana", 20));
	       lhm.add(new Price("Apple", 40));
	       lhm.add(new Price("Orange", 30));
	       lhm.add(new Price("Banana", 20));
	       System.out.println("@@@@@@@@@@@@ "+lhm+"\n");*/
	}
}

