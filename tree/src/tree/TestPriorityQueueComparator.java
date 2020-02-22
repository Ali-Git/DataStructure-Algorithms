package tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestPriorityQueueComparator {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10, 5, 20, 30, 25, 2);
		//A obj = new A(list);
		Queue<Integer> queueArrayVal = new PriorityQueue<>((a,b)->Integer.compare(a, b));
		Queue<Integer> queue1 = new PriorityQueue<>((a,b)->Integer.compare(list.get(a), list.get(b)));
		Queue<Integer> queue2 = new PriorityQueue<>((a,b)->Integer.compare(list.get(a), list.get(b)));
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(list.get(o1), list.get(o2));
			}});
		System.out.println();
		for(int i=0; i<list.size(); i++) {
			queue.add(i);
			queue1.add(i);
			queue2.add(i);
			queueArrayVal.add(list.get(i));
		}
		System.out.println(queue);
		System.out.println(queue1);
		System.out.println(queue2);
		System.out.println(queueArrayVal);
	}

}

// No need to create this object directly we can use annonymous inner classes or lambda that we have doinglike below
//Queue<Integer> queue = new PriorityQueue<>((a,b)->Integer.compare(list.get(i), list.get(j)));
class A implements Comparator<Integer>{
	
	List<Integer> list;
	
	public A(List<Integer> list) {
		this.list=list;
	}

	@Override
	public int compare(Integer i, Integer j) {
		return Integer.compare(list.get(i), list.get(j));
	}

}
