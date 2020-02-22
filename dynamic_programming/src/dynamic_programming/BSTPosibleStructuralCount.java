package dynamic_programming;

import java.util.Scanner;

public class BSTPosibleStructuralCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc_count=sc.nextInt();
		while(tc_count-- >0) {
			int node_count = sc.nextInt();
			int []BST = new int[node_count+1];
			BST[0]=1; // 0 index -> 0 node for calculation(multiplication) have put it 1
			BST[1]=1; // 1 index -> Node count 1
			for(int i=2; i<=node_count; i++) { 
				for(int j=0; j<i; j++) {
					BST[i] += BST[j]*BST[i-j-1];
				}
			}
			System.out.println("Number of Unique BST for n="+node_count+" is: "+BST[node_count]);
			
			
			
			
			
			/*
			 * 
			 * 
			int node_count = sc.nextInt();
			int []BST = new int[node_count+1];
			BST[0]=1; // 0 index -> 0 node for calculation(multiplication) have put it 1
			BST[1]=1; // 1 index -> Node count 1
			BST[2]=2; // 2 index -> Node count 2
			for(int i=3; i<=node_count; i++) { 
				for(int j=1; j<=i; j++) {
					BST[i]=BST[i]+BST[j-1]*BST[i-j];
				}
			}
			System.out.println("Number of Unique BST for n="+node_count+" is: "+BST[node_count]);
			 */
		}
		
	}

}
