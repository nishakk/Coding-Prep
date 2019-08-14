/**
 * Question: Given a 2D array of 1s and 0s, find the largest square subarray of all 1s.
 * @author nishakk
 *
 */
public class SquareMatrix {
	public static void main(String[] args) {
		boolean[][] mat = {
				{true, true, false},
				{true, true, true},
				{true, false, false}
		};
		System.out.println(squareSubmatrix(mat));
	}
	
	/**
	 * Naive recursive approach.
	 */
	public static int squareSubmatrix(boolean[][] arr) {
	    int max = 0;
	    // Compute recursively for each cell what it is the upper left corner of        
	    for (int i = 0; i < arr.length; i++) {
	        for (int j = 0; j < arr[0].length; j++) {
	            if (arr[i][j]) max = Math.max(max, squareSubmatrix(arr, i, j));
	        }
	    }
	        
	    return max;
	}

	private static int squareSubmatrix(boolean[][] arr, int i, int j) {
	    if (i == arr.length || j == arr[0].length || !arr[i][j]) return 0;
	     
	    return 1 + Math.min(Math.min(squareSubmatrix(arr, i+1, j), 
	                                 squareSubmatrix(arr, i, j+1)),
	                        squareSubmatrix(arr, i+1, j+1));
	}
}
