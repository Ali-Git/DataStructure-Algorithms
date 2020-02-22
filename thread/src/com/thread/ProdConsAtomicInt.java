package com.thread;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

class P implements Runnable {
	
	private AtomicInteger atm;
	
	public P(AtomicInteger atm){
		this.atm = atm;
	}
	
	public void run() {
		System.out.println("test-p");
		while(true) {
			if(atm.get()%2!=0) {
				System.out.print(atm.get()+" ");
				atm.incrementAndGet();
				if(atm.get()==50) break;
			}
		}

		
		
	}
	
}

class C implements Runnable {
	
	private AtomicInteger atm;
	
	public C(AtomicInteger atm){
		this.atm = atm;
	}
	
	public void run() {
		System.out.println("test-c");
		while(true) {
			if(atm.get()%2==0) {
				System.out.print(atm.get()+" ");
				if(atm.get()==50) break;
				atm.incrementAndGet();
			}
		}

	}
	
}

public class ProdConsAtomicInt {

	public static void main(String[] args) {
		Collections.synchronizedCollection(null);
		AtomicInteger atm = new AtomicInteger(1);
		Thread p = new Thread(new P(atm));
		Thread c = new Thread(new C(atm));
		p.start();
		c.start();
	}

}
