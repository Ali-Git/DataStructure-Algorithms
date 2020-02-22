package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 10, 20, 15, 30, 25, 60, 40, 50 };
		mergeSort(arr, 0, arr.length-1);
		System.out.println(arr);
	}
	
	  private static void mergeSort(int arr[], int l, int r){
	        if(l<r){
	            int m = (r + l)/2;
	            mergeSort(arr, l, m);
	            mergeSort(arr, m+1, r);
	            merge(arr, l, m, r);
	        }
	    }
	    
	    private static void merge(int arr[], int l, int m, int r){
	        int arrL[] = new int[m-l+1+1];
	        int arrR[] = new int[r-m+1];
	        int arrL_i=0;
	        int arrR_i=0;
	        for(int i=l; i<=r; i++){
	            if(i<=m){
	                arrL[arrL_i++]=arr[i];
	            }else{
	                arrR[arrR_i++]=arr[i];
	            }
	        }
	        arrL_i=0;
	        arrR_i=0;
	        arrL[arrL.length-1]=Integer.MAX_VALUE;
	        arrR[arrR.length-1]=Integer.MAX_VALUE;
	        for(int i=l; i<=r; i++){
	            if(arrL[arrL_i] < arrR[arrR_i]){
	                arr[i] = arrL[arrL_i];
	                arrL_i++;
	            }else{
	                arr[i] = arrR[arrR_i];
	                arrR_i++;
	            }
	            
	        }
	        
	    }	

}
