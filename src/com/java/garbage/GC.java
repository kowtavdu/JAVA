package com.java.garbage;

import java.util.LinkedList;
import java.util.List;

public class GC {

	public static void main(String args[]){
		List l = new LinkedList<>();
		do {
			l.add(new String("Hello Worl"));
		}while(true);
	}
}
