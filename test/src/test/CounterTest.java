package test;

public class CounterTest {
	static class Counter{
		int count;
	}
	static Counter counter = new Counter();
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			
			counter.count++;
		}
		
		System.out.println(counter.count);
		System.out.println(Math.pow(10,3));

	}

}
