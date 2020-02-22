package test;

class Abc {
	
	void test(String st) {
		System.out.println("hello");
	}
	
	void test(Object ob) {
		System.out.println("goooo");
	}
}

public class Test {


	public static void main(String[] args) {

		Abc test = new Abc();
		
		System.out.println("***********1**********");
		Runtime runtime = Runtime.getRuntime();
		System.out.println("AvailableProcessors: " + runtime.availableProcessors());
		System.out.println("FreeMemory: " + runtime.freeMemory());
		System.out.println("MaxMemory: " + runtime.maxMemory());
		System.out.println("TotalMemory: " + runtime.totalMemory());
		// char [] c = new char[2000000000];// OutOfMemory
		System.out.println("End !!");
	}

}
