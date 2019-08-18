import java.util.Arrays;
import java.util.HashMap;

/**
 * Question: Given an array, write a function to 
 * find any subarray that sums to zero, if one exists.
 * 
 * @author nishakk
 *
 */
public class ZeroSumSubarray {
	public static void main(String[] args) {
		int[] arr = {1, 2, -5, 1, 2, -1};
		System.out.println(Arrays.toString(zeroSum(arr)));
	}
	
	private static int[] zeroSum(int[] arr) {
		HashMap<Integer, Integer> sums = new HashMap<>();
		int sum = 0;
		for (int i = 0; i <= arr.length; i++) {
			Integer oldIdx = sums.get(sum);
			if (oldIdx == null && i == arr.length) return null;
			else if (oldIdx == null) {
				sums.put(sum, i);
				sum += arr[i];
			} else {
				return Arrays.copyOfRange(arr, oldIdx, i);
			}
		}
		return null;
	}
}
