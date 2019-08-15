/**
 * Question: Given an n x m array where all rows and columns are in sorted order,
 * write a function to determine whether the array contains an element x.
 * 
 * @author nishakk
 *
 */
public class SearchMatrix {
	public static void main(String[] args) {
		int[][] mat = {
				{1}
				};
		System.out.println(searchMatrix(mat, 0));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0) return false;
        int x=matrix[0].length-1;
        int y=0;
        while(x>=0 &&y<=matrix.length-1){
            if(matrix[y][x]==target){
                return true;
            }else if(matrix[y][x]>target){
                x--;
            }
            else{
                y++;
            }
        }
        return false;
    }
}
