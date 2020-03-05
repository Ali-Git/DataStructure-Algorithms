package com.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
}

public class OverlappingIntervals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int pair = sc.nextInt();
			List<Interval> list = new ArrayList<>();
			for (int i = 0; i < pair; i++) {
				list.add(new Interval(sc.nextInt(), sc.nextInt()));
			}
			list.sort((a, b)-> Integer.compare(a.start, b.start));
			Stack<Interval> stack = new Stack<>();
			for(Interval interval: list) {
				if(!stack.isEmpty() && stack.peek()!=null && overlap(stack.peek(), interval)) {
					Interval peek = stack.pop();
					if(peek.start>interval.start)
						peek.start=interval.start;
					if(peek.end<interval.end)
						peek.end=interval.end;
					stack.add(peek);
				}else {
					stack.add(interval);
				}
				
			}
			String result="";
			while(!stack.isEmpty()) {
				Interval peek = stack.pop();
				result =peek.start+" "+peek.end + " "+result;
			}
			System.out.println(result.trim());
		}
	}

	private static boolean overlap(Interval peek, Interval interval) {
		if(peek.end-interval.start>=0 && interval.end-peek.start >=0)
			return true;
		return false;
	}

}

/*
 * 
Input
2
4
1 3 2 4 6 8 9 10
4
6 8 1 9 2 4 4 7

Output
1 4 6 8 9 10
1 9
 * 
 */
