import java.util.ArrayList;
import java.util.List;

/**
 * Question: Given an integer matrix consisting of 1s and 0s, update it so that if any cell is 0, all the cells
 * in that row and column are 0.
 * 
 * @author nishakk
 *
 */
public class ZeroMatrix {
	public static void main(String[] args) {
		int[][] arr = {
				{0, 1, 1}, 
				{1, 1, 1},
				{1, 1, 1}
			};
		zeroMatrix(arr);
	}
	
	private static void zeroMatrix(int[][] mat) {
		List<List<Integer>> points = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0) {
					List<Integer> p = new ArrayList<>();
					p.add(i);
					p.add(j);
					points.add(p);
				}
			}
		}
		
		for (int i = 0; i < points.size(); i++) {
			int a = points.get(i).get(0);
			int b = points.get(i).get(1);
			for (int j = 0; j < mat.length; j++) {
				mat[j][b] = 0;
			}
			for (int j = 0; j < mat[0].length; j++) {
				mat[a][j] = 0;
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
