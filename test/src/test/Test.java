package test;

import java.util.Set;
import java.util.TreeSet;

public class Test {
	
	class Abc {
		
		void test(String st) {
			System.out.println("hello");
		}
		
		void test(Object ob) {
			System.out.println("goooo");
		}
	}


	public static void main(String[] args) {
		
		Set<Integer> tree = new TreeSet<>((a, b)->a.compare(b, a));
		tree.add(10);
		tree.add(4);
		tree.add(8);
		tree.add(15);
		for(int t: tree) {
			System.out.print(t+" ");
		}
		System.out.println("*************");

		Test.Abc test = new Test().new Abc();
		
		System.out.println("******1****##");
		Runtime runtime = Runtime.getRuntime();
		System.out.println("AvailableProcessors: " + runtime.availableProcessors());
		System.out.println("FreeMemory: " + runtime.freeMemory());
		System.out.println("MaxMemory: " + runtime.maxMemory());
		System.out.println("TotalMemory: " + runtime.totalMemory());
		// char [] c = new char[2000000000];// OutOfMemory
		System.out.println("End !!");
	}

}
