import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Question: Given an array of integers where each value 1 <= x <= len(array), 
 * write a function that finds all the duplicates in the array.
 * 
 * @author nishakk
 *
 */
public class FindDuplicates {
	public static void main(String[] args) {
		int[] arr = {2, 1, 2, 1};
		System.out.println(findDuplicates(arr));
	}
	
	private static List<Integer> findDuplicates(int[] arr) {
		Set<Integer> res = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int idx = Math.abs(arr[i]) - 1;
			if (arr[idx] < 0) {
				res.add(Math.abs(arr[i]));
			} else {
				arr[idx] = -arr[idx];
			}
		}
		
		return new ArrayList(res);
	}
}
