/**
 * Question: Given a 2D array of 1s and 0s, find the largest square subarray of all 1s.
 * @author nishakk
 *
 */
public class SquareMatrix {
	public static void main(String[] args) {
		int[][] mat = {
				{1, 1, 1, 0},
				{1, 1, 1, 0},
				{1, 1, 0, 0}
		};
		System.out.println(squareSubmatrixDP(mat));
	}
	
	/**
	 * Naive recursive approach.
	 */
	public static int squareSubmatrix(int[][] arr) {
	    int max = 0;
	    // Compute recursively for each cell what it is the upper left corner of        
	    for (int i = 0; i < arr.length; i++) {
	        for (int j = 0; j < arr[0].length; j++) {
	            if (arr[i][j] == 1) max = Math.max(max, squareSubmatrix(arr, i, j));
	        }
	    }
	        
	    return max;
	}

	private static int squareSubmatrix(int[][] arr, int i, int j) {
	    if (i == arr.length || j == arr[0].length || arr[i][j] == 0) return 0;
	     
	    return 1 + Math.min(Math.min(squareSubmatrix(arr, i+1, j), 
	                                 squareSubmatrix(arr, i, j+1)),
	                        squareSubmatrix(arr, i+1, j+1));
	}
	
	/**
	 * DP Solution
	 */
	public static int squareSubmatrixDP(int[][] arr) {
		int max = 0;
		int[][] sizes = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0 || j == 0) {
					sizes[i][j] = arr[i][j];
				} else if (arr[i][j] == 1) {
					sizes[i][j] = Math.min(Math.min(sizes[i-1][j], sizes[i][j-1]), sizes[i-1][j-1]) + 1;
				}
				max = max < sizes[i][j] ? sizes[i][j] : max;
			}
		}
		return max;
	}
}
