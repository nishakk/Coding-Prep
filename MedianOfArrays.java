/**
 * Question: Find the median of two sorted arrays.
 * 
 * @author nishakk
 *
 */
public class MedianOfArrays {
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5};
		int[] arr2 = {2, 4, 6};
		System.out.println(medianOfArrays(arr1, arr2));
	}
	
	/**
	 * Solution Time Complexity: O(n)
	 * Better Solution using Binary Search: O(log n)
	 */
	private static float medianOfArrays(int[] a1, int[] a2) {
		float[] arr = new float[a1.length + a2.length];
		int i = 0, j = 0;
		int idx = 0;
		while (i < a1.length && j < a2.length) {
			if (a1[i] < a2[j]) {
				arr[idx] = a1[i];
				i++;
			} else {
				arr[idx] = a2[j];
				j++;
			}
			idx++;
		}
		while (i < a1.length) {
			arr[idx] = a1[i];
			i++; idx++;
		}
		while (j < a2.length) {
			arr[idx] = a2[j];
			j++; idx++;
		}
		
		int medIdx = arr.length/2;
		if (arr.length % 2 == 0) {
			return (arr[medIdx - 1] + arr[medIdx]) / 2;
		}
		return arr[medIdx];
	}
}
