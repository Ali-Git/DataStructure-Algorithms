package com.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadTest {
	private static boolean stopRequested;
	//private static AtomicBoolean stopRequested = new AtomicBoolean(false);

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			int i = 0;
			while (!stopRequested) {
				System.out.println(i);
				i++;
			}	
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
		//stopRequested.set(true);
	}
}

