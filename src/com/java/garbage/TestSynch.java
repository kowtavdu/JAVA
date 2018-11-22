package com.java.garbage;

public class TestSynch {

	TestSynch(){
		System.out.println("Called in constructor");
	}
	public static void main(String[] args) {
		TestSynch tt = new TestSynch();
	}
}
