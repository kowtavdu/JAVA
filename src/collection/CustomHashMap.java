package collection;

import collection.cMap.Entry;

class Employee{
	private int id;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String name;
	
	@Override
	public int hashCode() {
		// this ensures all hashcodes are between 0 and 15
		return id % 10;
	}

	@Override
	public boolean equals(Object obj) {
		Employee otherEmp = (Employee) obj;
		return this.name.equals(otherEmp.name);
	}

	@Override
	public String toString() {
		return this.id + "-" + name;
	}
}

class cMap{
	private static final int SIZE = 16;
	private Entry table[] = new Entry[SIZE];

class Entry{

	Employee key;
	Entry(Employee k, String v){
		this.key = k;
		this.value = v;
	}
	public Employee getKey() {
		return key;
	}
	public void setKey(Employee key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	String value;
	Entry next;
   }
	private int getSupplementHash(int h){
		h ^= (h>>>20) ^ (h>>>12);
		return h ^ (h >>> 7) ^ (h >>> 4);		
	}
	private int getBucketNumber(int hash){
		return hash & (SIZE-1);
	}
	
	public void put(Employee key, String value){
		int userHash = key.hashCode();
		int hash = getSupplementHash(userHash);
		int bucket = getBucketNumber(hash);
		Entry existingElement = table[bucket];
		
		for(;existingElement!=null; existingElement = existingElement.next){
			
			if(existingElement.key.equals(key)){
				System.out.println("duplicate key value pair, replacing existing key "
						+ key + ", with value " + value);
				existingElement.value = value;
				return;
			}else{
				System.out.println("Collision detected for key " + key
						+ ", adding element to the existing bucket");
			}
		}
		
		System.out.println("PUT adding key:" + key + ", value:" + value
				+ " to the list");
		Entry entryInOldBucket = new Entry(key, value);
		entryInOldBucket.next = table[bucket];
		table[bucket] = entryInOldBucket;
	}
	
	public Entry get(Employee key){
		int hash = getSupplementHash(key.hashCode());
		int bucket = getBucketNumber(hash);
		Entry existingElement = table[bucket];
		while(existingElement!=null){
			System.out
			.println("Traversing the list inside the bucket for the key "
					+ existingElement.getKey());
			if(existingElement.key.equals(key)){
				return existingElement;
			}
			
			existingElement = existingElement.next;
		}
		return null;
	}
}
public class CustomHashMap {
 
	public static void main(String[] args) {
		cMap tmhm = new cMap();

		System.out.println("============== Adding Element ===================");
		Employee e1 = new Employee(100, "Niranjan");
		tmhm.put(e1, "dept1");

		// duplicate
		System.out
				.println("============== Adding Duplicate ===================");
		Employee e1_dup = new Employee(100, "Niranjan");
		tmhm.put(e1_dup, "dept12");
		// the above value "dept12" should replace the old value "dept1"
		Entry e = tmhm.get(e1_dup);
		System.out.println("GET element - " + e.getKey() + "::" + e.getValue());

		System.out
				.println("============== Adding Elements ===================");
		Employee e2 = new Employee(102, "Sravan");
		tmhm.put(e2, "dept3");
		
		System.out.println(tmhm);
	}
}
