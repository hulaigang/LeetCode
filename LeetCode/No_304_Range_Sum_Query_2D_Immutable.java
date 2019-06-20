package LeetCode;

/**
 * 与303题相比，二维的情况复杂一些，用（row1,col1,row2,col2）表示以（row1，col1）为左上顶点，以（row2,col2）为右下顶点的矩形中所有元素之和，则有：
 * 	（row1，col1，row2，col2） = （0,0，row2，col2）-（0,0，row1-1，col2）-（0,0，row2，col1-1）+（0，0，row1-1，col1-1）
 * 	这样就将任一矩阵化为了以（0,0）为顶点的矩阵元素和相加的式子
 * 	使用一个新的二维矩阵，来储存各个点与（0,0）构成的矩阵的元素和，使用动态规划的思想。
 * 	注意：考虑点在二维数组边上的情况
 */
public class No_304_Range_Sum_Query_2D_Immutable {
	private int[][] matrix; //原始矩阵
	private int[][] sum_matrix;//元素和的储存矩阵
	public No_304_Range_Sum_Query_2D_Immutable(int[][] matrix) {
		this.matrix = matrix;
		if (matrix.length==0 || matrix[0].length==0){
			sum_matrix = null;
		}else {
			sum_matrix = new int[matrix.length][matrix[0].length];
			for (int i=0;i<matrix.length;i++){
				for (int j=0;j<matrix[i].length;j++){
					sum_matrix[i][j] = matrix[i][j];
					if (i>0 && j>0){
						sum_matrix[i][j] += sum_matrix[i-1][j]+sum_matrix[i][j-1]-sum_matrix[i-1][j-1];
					}else if (i>0){
						sum_matrix[i][j] += sum_matrix[i-1][j];
					}else if (j>0){
						sum_matrix[i][j] += sum_matrix[i][j-1];
					}
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (sum_matrix==null) return 0;
		if (row1>0 && col1>0){
			return sum_matrix[row2][col2] - sum_matrix[row1-1][col2] -sum_matrix[row2][col1-1] + sum_matrix[row1-1][col1-1];
		}else if (row1>0){
			return sum_matrix[row2][col2] - sum_matrix[row1-1][col2];
		}else if (col1>0){
			return sum_matrix[row2][col2] - sum_matrix[row2][col1-1];
		}else {
			return sum_matrix[row2][col2];
		}
	}
}
