package com.thread;

public class JenkovThreadTest {

	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);

		threadA.start();
		threadB.start();
		try {
			threadA.join(); // current thread should join the threadA when its completed..
			threadB.join(); // current thread should join the threadB when its completed..
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(counter.count);
	}

}

class Counter {

	long count = 0;

	public synchronized void add(long value) {
		this.count += value;
	}
}

class CounterThread extends Thread {

	protected Counter counter = null;

	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			counter.add(i);
		}
	}
}