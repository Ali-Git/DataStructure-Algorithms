package com.array;

import java.util.Scanner;
// Design a tiny URL or URL shortener
// https://practice.geeksforgeeks.org/problems/design-a-tiny-url-or-url-shortener/0

public class TinyURL {
	
	private static String base62="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0) {
			int num=sc.nextInt();
			StringBuilder result=new StringBuilder();
			while(num!=0) {
				int m= num%62;
				int d = num/62;
				num=d;
				result.append(base62.charAt(m));
			}
			System.out.println("result: "+result);
		}
	}
	
	

	public static void RND(String[] args) {
		int dec = 158;
		String hex = Integer.toHexString(dec);
	    System.out.println(hex);
	      
	    String str = "3d8";
	    System.out.println(Integer.parseInt(str, 16));
		System.out.println("*************************");
		int a=158;
		System.out.println(a/12);
		System.out.println(a%12);
		
		System.out.println(13/12);
		System.out.println(13%12);
		
		// 12*12 =144 = 100
		// 14 = 12
		// 112
		
		//112
		String st = "";
		char arr[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'};
		while(a!=0) {
			int m = a%12;
			int d = a/12;
			a=d;
			st = m+st;
		}
		System.out.println("st: "+st);
		
		
		
		String s="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String result="";
		int num=12345;
		while(num!=0) {
			int m= num%62;
			int d = num/62;
			num=d;
			result = s.charAt(m)+result;
		}
		System.out.println("result: "+result);
	}

}

/*
 * 

Example:
Input:
1
12345

Output:
dnh
12345

Input:
1
16808

Its Correct output is:
exg
16808

And Your Code's output is:
exg
thoSA
*/

