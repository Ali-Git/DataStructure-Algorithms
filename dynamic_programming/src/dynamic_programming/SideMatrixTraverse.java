package dynamic_programming;

public class SideMatrixTraverse {

	public static void main(String[] args) {
		// ***2nd***
		int NR[][] = new int[4][4];
		int ncounter=0;
		for(int i=0; i<4; i++) {
			NR[i][i] = ++ncounter;
		}
		
		
		for(int l=1; l<4; l++) {
			for(int i=0; i<4; i++) {
				for(int j=i+l; j<4; j++) {
					NR[i][j] = ++ncounter;
					break;
				}
			}
		}

		System.out.println(NR);
		
		
		// ***1st***
		int counter=0;
		int R[][] = new int[5][5];
		for(int l=0; l<5; l++) {
			for(int i=0; i<5; i++) {
				if((i+l)<5) {
					R[i][i+l] = ++counter;
				}
			}
		}
		System.out.println(R);
	}

}
