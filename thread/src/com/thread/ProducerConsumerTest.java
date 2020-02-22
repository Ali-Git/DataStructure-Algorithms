package com.thread;
/**
 * This is perfect prod-cons program,
 * where both the producer and consumer threads exit smoothly.
 * To verify - You can check in the console that red button will not come to stop the process of execution.
 * That means none of the thread is waiting to get notified..!!
 * 
 */
import java.util.LinkedList;
import java.util.Queue;

class Producer extends Thread {
	
	Queue<String> queue;
	
	Producer(Queue<String> queue){
		this.queue = queue;
	}
	
	public void run() {
		String str = "ABCDEFGHI";
		synchronized(queue) {
			for(int i=0; i<str.length(); i++) {
				System.out.print(String.valueOf(str.charAt(i))+" ");
				queue.add("TEST");
				queue.notify();
				if(String.valueOf(str.charAt(i)).equals("I")) {
					//System.out.print(" p "); // For smooth exit of thread..
					break;
				}
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

class Consumer extends Thread {
	
	Queue<String> queue;
	
	Consumer(Queue<String> queue){
		this.queue = queue;
	}
	
	public void run() {
		String str = "123456789";
		synchronized(queue) {
			for(int i=0; i<str.length(); i++) {
				while(queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(String.valueOf(str.charAt(i)).equals("9 ")) {
					System.out.print("4");
					//System.out.print(" c "); // For smooth exit of thread..
					break;
				}
				System.out.print(String.valueOf(str.charAt(i))+" ");
				queue.remove();
				queue.notify();
			}
		}
	}
}

public class ProducerConsumerTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList();
		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);
		p.start();
		c.start();

	}

}
