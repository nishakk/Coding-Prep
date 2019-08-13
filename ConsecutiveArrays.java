import java.util.HashSet;
import java.util.Set;

/**
 * Question: Given an unsorted array, find the length of the longest sequence of
 * consecutive numbers in the array.
 * 
 * @author nishakk
 *
 */
public class ConsecutiveArrays {
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 5, 6, 7, 8};
		System.out.println(consecutiveArrays(arr));
	}
	
	private static int consecutiveArrays(int[] arr) {
		int maxLen = 1;
		Set<Integer> set = new HashSet<Integer>();
		for (int n : arr) {
			set.add(n);
		}
		for (int num : arr) {
			if (set.contains(num - 1)) continue;
			if (set.contains(num+1)) {
				int temp = num-1;
				int count = 1;
				temp = num+1;
				while(set.contains(temp)) {
					temp++;
					count++;
				}
				maxLen = maxLen < count ? count : maxLen;
			}
		}
		
		return maxLen;
	}
}
