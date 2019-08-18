import java.util.Arrays;

/**
 * Question: Given 2 sorted arrays, A and B, 
 * where A is long enough to hold the contents of A and B, 
 * write a function to copy the contents of B into A without using any buffer or additional memory.
 * 
 * @author nishakk
 *
 */
public class MergeArrays {
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 0, 0};
		int[] b = {4, 6};
		System.out.println(Arrays.toString(merge(a, b, 3, 2)));
	}
	
	private static int[] merge(int[] a, int[] b, int aLen, int bLen) {
		int mergeIdx = aLen + bLen - 1;
		int i = aLen - 1;
		int j = bLen - 1;
		while (i >= 0 && j >=0) {
			if (a[i] > b[j]) {
				a[mergeIdx] = a[i];
				i--;
			} else {
				a[mergeIdx] = b[j];
				j--;
			}
			mergeIdx--;
		}
		
		while (j >= 0) {
			a[mergeIdx] = b[j];
			j--; mergeIdx--;
		}
		
		return a;
	}
}
