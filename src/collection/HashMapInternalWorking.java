package collection;

import java.util.HashMap;
import java.util.Iterator;

class Country{
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	long population;
	
	public Country(String name, long population){
		super();
		this.name = name;
		this.population = population;
	}
	
	@Override
	public int hashCode(){
		if(this.name.length()%2==0)
		return 31;
		else
		return 95;	
	}
	
	public boolean equals(Object obj){
		Country ctry = (Country) obj;
		if(name.equalsIgnoreCase(ctry.getName()))
			return true;
			else
			return false;	
	}
}

public class HashMapInternalWorking {

	public static void main(String[] args) {
		HashMap<Country, String> hm = new HashMap<Country, String>();
		Country india = new Country("india", 200);
		Country japan = new Country("japan", 300);
		Country france = new Country("france", 400);
		Country russia = new Country("russia", 500);
		
		hm.put(india, "delhi");
		hm.put(japan, "tokyo");
		hm.put(france, "paris");
		hm.put(russia, "moscow");
		hm.put(russia, "moscow1");
		
		
		Iterator<Country> it = hm.keySet().iterator();
		while(it.hasNext()){
			Country ctr = it.next();
			String capital = hm.get(ctr);
			System.out.println(ctr.getName()+"--------------"+capital);
		}
	}
}
