package sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 10, 20, 15, 30, 25, 60, 40, 50 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(arr);
	}

	static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	static int partition(int arr[], int low, int high) {
		int i = low - 1; // pivot_index
		for (int j = low; j < high; j++) {
			if (arr[j] < arr[high]) {
				i = i + 1;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[high];
		arr[high] = arr[i + 1];
		arr[i + 1] = temp;
		return ++i;
	}
}
