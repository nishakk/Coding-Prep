/**
 * Questions: Given a matrix, find the path from top left to bottom right with the
 * greatest product by moving only down and right.
 * 
 * @author nishakk
 *
 */
public class MatrixProduct {
	public static void main(String[] args) {
		int[][] mat = {
						{-1, 2, 3},
						{4, 5, -6},
						{7, 8, 9}
					};
		System.out.println(greatestMatrixProductDFS(mat, 0, 0, 1));
		System.out.println(greatestMatrixProductIter(mat));
	}
	
	/**
	 * Brute Force DFS Solution
	 */
	private static int greatestMatrixProductDFS(int[][] mat, int i, int j, int prod) {
		if (i >= mat.length || j >= mat[0].length) return prod;
		prod *= mat[i][j];
		return Math.max(greatestMatrixProductDFS(mat, i+1, j, prod), greatestMatrixProductDFS(mat, i, j+1, prod));
	}
	
	/**
	 * Improved Performance Iterative Solution
	 */
	private static int greatestMatrixProductIter(int[][] mat) {
		int[][] maxPath = new int[mat.length][mat[0].length];
		int[][] minPath = new int[mat.length][mat[0].length];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (i == 0 && j == 0) {
					maxPath[i][j] = mat[i][j];
					minPath[i][j] = mat[i][j];
				} else if (i == 0) {
					maxPath[i][j] = mat[i][j] * maxPath[i][j-1];
					minPath[i][j] = maxPath[i][j];
				} else if (j == 0) {
					maxPath[i][j] = mat[i][j] * maxPath[i-1][j];
					minPath[i][j] = maxPath[i][j];
				} else {
					int maxLeft = mat[i][j] * maxPath[i-1][j];
					int maxUp = mat[i][j] * maxPath[i][j-1];
					int minLeft = mat[i][j] * minPath[i-1][j];
					int minUp = mat[i][j] * minPath[i][j-1];
					maxPath[i][j] = Math.max(Math.max(maxLeft, maxUp), Math.max(minLeft, minUp));
					minPath[i][j] = Math.min(Math.min(maxUp, maxLeft), Math.min(minLeft, minUp));
				}
			}
		}
		
		return maxPath[maxPath.length-1][maxPath[0].length-1];
	}
}
