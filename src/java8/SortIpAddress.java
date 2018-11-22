package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortIpAddress {

	public static void main(String[] args) {
		
    List<String> ipAddresses = new ArrayList<>();
    ipAddresses.add("123.4.245.23");
    ipAddresses.add("104.244.253.29");
    ipAddresses.add("1.198.3.93");
    ipAddresses.add("32.183.93.40");
    ipAddresses.add("104.30.244.2");
    ipAddresses.add("104.244.4.1");
	
    Collections.sort(ipAddresses, new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			String [] obj1 = o1.split("\\.");
			String [] obj2 = o1.split("\\.");
			
			String newObject1 = String.format("%3s.%3s.%3s.%3s", obj1[0],obj1[1],obj1[2], obj1[3]);
			String newObject2 = String.format("%3s.%3s.%3s.%3s", obj2[0],obj2[1],obj2[2], obj2[3]);
			// TODO Auto-generated method stub
			
			return newObject1.compareTo(newObject2);
			 
		}
    	
    	
	});
    
       for(String ipAddress : ipAddresses){
    	   System.out.println(ipAddress);
       }
       
       System.out.println(ipAddresses.subList(1, 4));
	}
}
