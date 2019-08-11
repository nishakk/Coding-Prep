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
		System.out.println(findMedianSortedArraysBinarySearch(arr1, arr2));
	}
	
	/**
	 * Solution Time Complexity: O(n)
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
	
	/**
	 * Binary Search Solution Time Complexity: O(log(min(m,n)))
	 */
	private static double findMedianSortedArraysBinarySearch(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArraysBinarySearch(nums2, nums1);
		}
		
		int m = nums1.length;
		int n = nums2.length;
		int lo = 0;
		int hi = m;
		while (lo <= hi) {
			int i = lo + (hi - lo) / 2;
			int j = (m + n + 1) / 2 - i;
			int maxLeftA = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
			int minRightA = i == m ? Integer.MAX_VALUE : nums1[i];
			
			int maxLeftB = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
			int minRightB = j == n ? Integer.MAX_VALUE : nums2[j];
			
			if (maxLeftA <= minRightB && maxLeftB >= minRightA) {
				if ((m + n) % 2 == 0) {
					return (double)(Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
				} else {
					return (double)(Math.max(maxLeftA, maxLeftB));
				}
			} else if (maxLeftA > minRightB) {
				hi = i - 1;
			} else {
				lo = i + 1;
			}
		}
		
		return 0.0;
	}
}
