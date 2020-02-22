package dynamic_programming;

import java.util.Scanner;
// Regular Expression Dynamic Programming - Tushar 24.
// https://www.youtube.com/watch?v=l3hda49XcDE&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=15
public class RegexStarDotMatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			String regex ="xa*b.c";
			String input = "xaabyc";
			char [] reg = new char[regex.length()];
			char [] inp = new char[input.length()];
			for(int i=0; i<regex.length(); i++) {
				reg[i] = regex.charAt(i);
			}
			for(int i=0; i<input.length(); i++) {
				inp[i] = input.charAt(i);
			}
			boolean [][] R = new boolean [input.length()+1][regex.length()+1];
			R[0][0]=true;
			for(int i=1; i<input.length()+1; i++) {
				for(int j=1; j<regex.length()+1; j++) {
					if('*'==reg[j-1]) {
						if(R[i][j-2]==true) {
							R[i][j]=true;
						}else {
							if(R[i-1][j]==true && inp[i-1]==reg[j-1-1]) {
								R[i][j]=true;
							}
						}
					}else if('.'==reg[j-1]) {
						R[i][j] = R[i-1][j-1];
					}else if(inp[i-1]==reg[j-1]) {
						R[i][j] = R[i-1][j-1];
					}
				}
			}
			System.out.println(R[input.length()][regex.length()]);
		}

	}

}
