package com.java.garbage;

public class GcScope {

	GcScope t;
	static int i =1;
	
	public static void main(String args[]){
		GcScope t1 = new GcScope();
		GcScope t2 = new GcScope();
		GcScope t3 = new GcScope();
		
		t1.t = t2;
		t2.t = t3;
		t3.t = t1;
		
		t1 = null;
		t2 = null;
		t3 = null;
	}
	
	protected void finalize(){
		System.out.println("Garbage collected from object"+i);
	    i++;	
	}
}
