package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ZeroOddEven {
	static volatile int i = 1;
	//static AtomicInteger i = new AtomicInteger(1);// incrementAndGet()  && decrementAndGet()
	static boolean zeroFlag = true;
	static Object obj = new Object();


	public static void main(String[] args) {

		Thread ot= new Thread(new Runnable() {
			public void run() {
				while(true) {
					synchronized (obj) {
						try {
							while(zeroFlag == true || (zeroFlag == false && i%2 == 0)) {
								if(i -1 == 100) {
									obj.notifyAll();
									break;
								}
								obj.wait();
							}
//							Thread.sleep(1000);
							if(i -1 == 100) {
								obj.notifyAll();
								break;
							}
							System.out.println(i++ + "-->" + Thread.currentThread().getName());
							zeroFlag = true;
							obj.notifyAll();
						} catch (InterruptedException e) {

						}
					}
				}
			}
		}, "Odd Thread"); 

		Thread et= new Thread(new Runnable() {
			public void run() {
				while(true) {
					synchronized (obj) {
						try {
							while(zeroFlag == true || (zeroFlag == false && i%2 != 0)) {
								obj.wait();
							}
//							Thread.sleep(1000);
							System.out.println(i++ + "-->" + Thread.currentThread().getName());
							if(i -1 == 100) {
								obj.notifyAll();
								break;
							}
							zeroFlag = true;
							obj.notifyAll();
						} catch (InterruptedException e) {

						}
					}
				}
			}
		}, "Even Thread");

		Thread zt= new Thread(new Runnable() {
			public void run() {
				while(true) {
					synchronized (obj) {
						try {
							while(zeroFlag == false) {
								if(i -1 == 100) {
									obj.notifyAll();
									break;
								}
								obj.wait();
							}
//							Thread.sleep(1000);
							if(i -1 == 100) {
								obj.notifyAll();
								break;
							}
							System.out.println(0 + "-->" + Thread.currentThread().getName());
							zeroFlag = false;
							obj.notifyAll();
						} catch (InterruptedException e) {

						}
					}
				}
			}
		}, "Zero Thread");

		ot.start();
		zt.start();
		et.start();

	}

}
