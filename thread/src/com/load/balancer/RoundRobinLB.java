package com.load.balancer;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RoundRobinLB {
	private static int[] servers = new int[] { 0, 1, 2 };

	private static int SERVER_INDEX = 0;

	// not fast enough?
	public synchronized static int getServer() {
		SERVER_INDEX++;
		if (SERVER_INDEX >= servers.length - 1) {
			SERVER_INDEX = 0;
		}
		return servers[SERVER_INDEX];
	}

	private static AtomicInteger SERVER_INDEX_2 = new AtomicInteger(0);

	// not thread-safe and will get Exception
	public static int getServer2() {
		int index = SERVER_INDEX_2.getAndIncrement();
		if (index >= servers.length - 1) {
			SERVER_INDEX_2.set(0);
		}
		return servers[index]; // ERROR! arrayIndexOutOfRange
	}

	private static AtomicLong SERVER_INDEX_3 = new AtomicLong(0);

	// thread-safe but...
	public static int getServer3() {
		long longIndex = SERVER_INDEX_3.getAndIncrement();
		long index = longIndex % servers.length;
		int intIndex = (int) index;
		return servers[intIndex]; // May overflow someday! 'intIndex can be negative'...
	}

	public static void main(String[] args) {
		Set<Character> set = new HashSet<>();
		String str = "ABC";
		for(Character c :str.toCharArray()) {
			System.out.print(c+" ");
		}
	}

	private static AtomicInteger ind = new AtomicInteger(0);

	public static int getServerRes() {
		return servers[ind.getAndAccumulate(servers.length, (cur, n) -> cur >= n - 1 ? 0 : cur + 1)];
	}

}
