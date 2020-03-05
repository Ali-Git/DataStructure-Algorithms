package com.array;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
// The Celebrity Problem
public class CelebrityProblem
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					M[i][j] = sc.nextInt();
				}
			}
		System.out.println(new Celebrity().getId(M,N));
		t--;
		}
	}
}
//} Driver Code Ends
class Celebrity
{
 // The task is to complete this function
 int getId(int M[][], int n)
 {
     int result=-1;
     int findRow=-1;
     boolean flag=false;
     for(int i=0; i<n; i++){
         for(int j=0; j<n; j++){
             if(i==j && j==n-1){
                 flag=true;
                 for(int k=0; k<n; k++){
                     if(M[i][k]==1){
                         flag=false;
                         break;
                     }
                 }
             }
             if(i==j) continue;
             if(M[j][i]==0)
                 break;
             if(j==n-1){
                 flag=true;
                 for(int k=0; k<n; k++){
                     if(M[i][k]==1){
                         flag=false;
                         break;
                     }
                 }
                 
             }
         }
         if(flag){
             result=i;
             break;
         }
     }
     return result;
 }
}


/*

Input (To be used only for expected output) :
2
3
0 1 0 0 0 0 0 1 0
2
0 1 1 0

Output :
1
-1

*/


