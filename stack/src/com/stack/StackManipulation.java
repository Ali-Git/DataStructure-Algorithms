package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class StackManipulation {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int q = sc.nextInt();
			GfG g = new GfG();
			while (q > 0) {
				int qt = sc.nextInt();

				if (qt == 1) {
					int att = sc.nextInt();
					g.push(att);
					// System.out.println(att);
				} else if (qt == 2) {
					System.out.print(g.pop() + " ");
				} else if (qt == 3) {
					System.out.print(g.getMin() + " ");
				}

				q--;
			}
			System.out.println();
			T--;
		}

	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
class GfG {
	int minEle = Integer.MAX_VALUE;
	Stack<Integer> s = new Stack<>();

	/* returns min element from stack */
	int getMin() {
		if (s.empty())
			return -1;
		else {
			return minEle;
		}
	}

	/* returns poped element from stack */
	int pop() {
		if (s.empty())
			return -1;
		else {
			int temp = s.pop();
			if (temp == minEle) {
				minEle = Integer.MAX_VALUE;
				Stack<Integer> tempStack = new Stack<>();
				while (!s.empty()) {
					int pop = s.pop();
					if (minEle > pop)
						minEle = pop;
					tempStack.push(pop);
				}
				while (!tempStack.isEmpty()) {
					s.push(tempStack.pop());
				}
			}
			return temp;
		}
	}

	/* push element x into the stack */
	void push(int x) {
		if (x < minEle)
			minEle = x;
		s.push(x);
	}
}



/*
1
18
2 2 2 1 95 3 1 71 3 2 3 1 98 3 1 93 2 3 2 3 3 2

Its Correct output is:
-1 -1 -1 95 71 71 95 95 93 95 98 95 95 95

And Your Code's output is:
-1 -1 -1 95 71 71 95 95 93 95 95 98 98 98
*/