package LeetCode;

/**
 * 按照顺时针顺序，逐层生成元素
 */
public class No_059_Spiral_Matrix_II {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int i=1;
		int start=0,length=n-1;
		while (start<=length){
			for (int j=start;j<=length;j++){
				matrix[start][j] = i;
				i++;
			}
			for (int j=start+1;j<length;j++){
				matrix[j][length] = i;
				i++;
			}
			for (int j=length;j>=start && length!=start;j--){
				matrix[length][j] = i;
				i++;
			}
			for (int j=length-1;j>start;j--){
				matrix[j][start] = i;
				i++;
			}
			start++;
			length--;
		}
		return matrix;
	}
}
