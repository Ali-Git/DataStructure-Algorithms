package com.hash;

import java.util.Scanner;
// https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string/0
// Smallest window in a string containing all the characters of another string
public class SmallestWindowString {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			String big = sc.next();
			String small = sc.next();
			int smallSize = small.length();
			int smallArr[] = new int[128];
			for (Character c : small.toCharArray()) {
				smallArr[c]=smallArr[c] +1;
			}
			char[] ch = big.toCharArray();
			int bigArr[] = new int[128];
			int i=0, j=0, sizeCounter=0, l = ch.length;
			int m=Integer.MAX_VALUE, n=0;
			while(i<l && j<l){
			    bigArr[ch[j]] += 1; 
			    if(bigArr[ch[j]] <= smallArr[ch[j]])
			        sizeCounter++;
			    while(sizeCounter==smallSize){
			        if(m-n > j-i){
			            m=j;
			            n=i;
			        }
			        if(bigArr[ch[i]] -1 < smallArr[ch[i]]){
			            sizeCounter--;
			        }
			        bigArr[ch[i]] -= 1;
			        i++;
			    }
			    j++;
			}
			
		    System.out.println("m: "+m+" | n: "+n);
		    System.out.println(big.substring(n, m+1));
		}
	}
}


/*
Input:
2
timetopractice
toc
zoomlazapzo
oza

Output:
toprac
apzo

Explanation:
Testcase 1: "toprac" is the smallest substring in the given string S which contains every characters of T.
*/
