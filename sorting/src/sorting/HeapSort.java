package sorting;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 10, 20, 15, 30, 25, 60, 40, 50 };
		int n = arr.length;
		heapSort(arr, n);
		//System.out.println(arr);
		printArray(arr, n);

	}
	
    static void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    static public void heapSort(int arr[], int n)
    {
        buildHeap(arr, n);
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void buildHeap(int arr[], int n)
    {
        int lnln = (n/2)-1; // last non leaf node
        for(int i=lnln; i>=0; i--){
            //System.out.println("arr: "+arr[i]+" | n: "+n+" | i: "+i);
            heapify(arr, n, i);
        }
/*        for(int i=0; i<n; i++){
            System.out.print(arr[i]+"**");
        }*/
        //System.out.println("***done***");
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int n, int i)
    {
        int largest=i; // largest vlue index for a subtree (heap)
        int l = 2*i+1; // left_index
        int r = 2*i+2; // lright_index
        if(l<n && arr[largest] < arr[l]){
            //System.out.println("I->largest: "+largest + " | l:"+l);
            largest=l;
            //System.out.println("O->largest: "+largest + " | l:"+l);
        }
        if(r<n && arr[largest] < arr[r]){
            //System.out.println("eI->largest: "+largest + " | l:"+r);
            largest=r;
            //System.out.println("eO->largest: "+largest + " | l:"+r);
        }
        if(largest!=i){ // largest is not equal to i then swap
            int temp=arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            //System.out.println("swap->largest: "+largest + " | i:"+i);
            //System.out.println("SWAP->arr[largest]: "+arr[largest] + " | arr[i]:"+arr[i]);
            heapify(arr, n, largest); // this process would repeat for the child..
            //System.out.println("**********************");
        }
    }
}
