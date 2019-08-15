import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	public static void main(String[] args) {
		int[][] arr = {
				{1, 4, 7},
				{2, 5, 8},
				{3, 6, 9}
		};
		System.out.println(Arrays.toString(merge(arr)));
	}
	
	/**
	 * Naive solution
	 */
	public static int[] mergeKArrays(int[][] arrays) {
		int[] mergedArr = arrays[0];
		for (int i = 1; i < arrays.length; i++) {
			mergedArr = mergeTwoArrays(mergedArr, arrays[i]);
		}
		return mergedArr;
	}
	
	public static int[] mergeTwoArrays(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length + arr2.length];
		int index = 0;
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr[index] = arr1[i];
				i++;
			} else {
				arr[index] = arr2[j];
				j++;
			}
			index++;
		}
		
		while (i < arr1.length) {
			arr[index] = arr1[i];
			i++; index++;
		}
		
		while (j < arr2.length) {
			arr[index] = arr2[j];
			j++; index++;
		}
		
		return arr;
	}
	
	/**
	 * Better Solution O(nlogn)
	 */
	private static class QueueNode implements Comparable<QueueNode> {
		int array, index, value;
		
		public QueueNode(int array, int index, int value) {
			this.array = array;
			this.index = index;
			this.value = value;
		}
		
		public int compareTo(QueueNode q) {
			if (value > q.value) return 1;
			if (value < q.value) return -1;
			return 0;
		}
	}
	
	public static int[] merge(int[][] arrays) {
		PriorityQueue<QueueNode> pq = new PriorityQueue<>();
		int size = 0;
		for (int i = 0; i < arrays.length; i++) {
			size += arrays[i].length;
			if (arrays.length > 0) {
				pq.add(new QueueNode(i, 0, arrays[i][0]));
			}
		}
		
		int[] res = new int[size];
		for (int i = 0; !pq.isEmpty(); i++) {
			QueueNode q = pq.poll();
			res[i] = q.value;
			int newIndex = q.index + 1;
			if (newIndex < arrays[q.array].length) {
				pq.add(new QueueNode(q.array, newIndex, arrays[q.array][newIndex]));
			}
		}
		return res;
	}
}
