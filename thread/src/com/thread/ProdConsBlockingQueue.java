package com.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProdConsBlockingQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Thread p = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (queue) {
					for (int i = 5; i <=45; i=i+10) {
						queue.add(i);
						System.out.print(i + " - ");
						queue.notify();
						try {
							if (i != 45)
								queue.wait();
						} catch (InterruptedException e) {
						}
					}
				}
			}
			
		});
		Thread c = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (queue) {
					for (int i = 10; i <=50; i=i+10) {
						while (queue.isEmpty()) {
							try {
								queue.wait();
							} catch (InterruptedException e) {
							}
						}
						System.out.println(i);
						queue.notify();
						try {
							if (i !=50 )
								queue.wait();
						} catch (InterruptedException e) {
						}

					}

				}

			}
			
		});
		p.start();
		c.start();
	}
}