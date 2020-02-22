package com.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Counter {
	int counter; //(new Counter()).i;
}

class ZeroThread extends Thread {
	
	Queue<String> queue;
	
	ZeroThread(Queue<String> queue){
		this.queue = queue;
	}
	
	public void run() {
		Stack<String> stack = new Stack();
		stack.push("J");
		stack.push("I");
		stack.push("H");
		stack.push("G");
		stack.push("F");
		stack.push("E");
		stack.push("D");
		stack.push("C");
		stack.push("B");
		stack.push("A");
		synchronized(queue) {
			while(!stack.isEmpty()) {
				while(!queue.isEmpty()) {
					queue.notifyAll();
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				String check="";
				if((stack.size())%2==0) {
					check = "[ONE]";
					queue.add("ONE");
				}else {
					check = "[TWO]";
					queue.add("ONE");
					queue.add("TWO");
				}
				System.out.print(stack.pop()+check+" ");
				queue.notifyAll();
				System.out.println("-----------------------Thread-zero going to wait..");
				if(stack.isEmpty()) break;
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

class OddThread extends Thread {
	
	Queue<String> queue;
	
	OddThread(Queue<String> queue){
		this.queue = queue;
	}
	
	public void run() {
		String str = "13579";
		Stack<Integer> stack = new Stack();
		stack.push(9);
		stack.push(7);
		stack.push(5);
		stack.push(3);
		stack.push(1);
		synchronized(queue) {
			while(!stack.isEmpty()) {
				while(queue.isEmpty() || queue.size()!=1) {
//					queue.notifyAll();
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} 
				System.out.print(stack.pop()+"{odd-size:"+queue.size());
				queue.clear();
				System.out.print("-"+queue.size()+"} ");
				System.out.println("--------------Thread-odd going to wait..");
				queue.notifyAll();
				if(stack.isEmpty()) break;
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class EvenThread extends Thread {
	
	Queue<String> queue;
	
	EvenThread(Queue<String> queue){
		this.queue = queue;
	}
	
	public void run() {
		String str = "2468";
		Stack<Integer> stack = new Stack();
		stack.push(10);
		stack.push(8);
		stack.push(6);
		stack.push(4);
		stack.push(2);
		synchronized(queue) {
			while(!stack.isEmpty()) {
				while(queue.isEmpty() || queue.size()!=2) {
//					queue.notifyAll();
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(stack.pop()+"{even-size:"+queue.size());
				queue.clear();
				System.out.print("-"+queue.size()+"} ");
				queue.notifyAll();
				System.out.println("-------------Thread-even going to wait..");
				if(stack.isEmpty()) break;
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}

public class ZeroOddZeroEvenProducerConsumer {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList();
		ZeroThread zt = new ZeroThread(queue); 
		OddThread ot = new OddThread(queue); 
		EvenThread et = new EvenThread(queue);
		zt.setName("Thread-zero");
		ot.setName("Thread-odd");
		et.setName("Thread-even");
		zt.start();
		ot.start();
		et.start();

	}

}
/*
package test.thread;

import java.util.LinkedList;
import java.util.Queue;

class ZeroThread extends Thread {
	
	Queue<String> queue;
	
	Boolean flag;
	
	ZeroThread(Queue<String> queue, Boolean flag){
		this.queue = queue;
		this.flag = flag;
	}
	
	public void run() {
		
		synchronized(queue) {
			for(int i=2; i<12; i++) {
				if(queue.isEmpty()) {
					System.out.print("0 ");
					queue.add("As we have taken type of Queue is String => It could be any string");
					if(i%2==0) {
						flag=true;
						System.out.print("{");
					}else {
						flag=false;
						System.out.print("}");
					}
					queue.notifyAll();
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
			}
		}
		
	}
}

class OddThread extends Thread {
	
	Queue<String> queue;
	
	Boolean flag;
	
	OddThread(Queue<String> queue, Boolean flag){
		this.queue = queue;
		this.flag = flag;
	}
	
	public void run() {
		String str = "13579";
		if(flag) {
			synchronized(queue) {
				for(int i=0; i<str.length(); i++) {
					if(!queue.isEmpty()) {
						System.out.print(String.valueOf(str.charAt(i))+" ");
						//flag = false;
						queue.remove();
						queue.notifyAll();
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}
	}
}

class EvenThread extends Thread {
	
	Queue<String> queue;
	
	Boolean flag;
	
	EvenThread(Queue<String> queue, Boolean flag){
		this.queue = queue;
		this.flag = flag;
	}
	
	public void run() {
		String str = "2468";
		System.out.print("*");
		if(!flag) {
			synchronized(queue) {
				for(int i=0; i<str.length(); i++) {
					if(!queue.isEmpty()) {
						System.out.print(String.valueOf(str.charAt(i))+" ");
						//flag = true;
						queue.remove();
						queue.notifyAll();
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}
	}
}

public class ZeroOddZeroEvenProducerConsumer {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList();
		Boolean flag = true;
		ZeroThread zt = new ZeroThread(queue, flag); 
		OddThread ot = new OddThread(queue, flag); 
		EvenThread et = new EvenThread(queue, flag); 
		zt.start();
		ot.start();
		et.start();

	}

}
//whichever flag in the if() condition we are setting it true..only that thread is executing next

*/