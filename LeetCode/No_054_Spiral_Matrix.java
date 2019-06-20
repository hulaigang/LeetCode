package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照顺时针顺序，逐层读取二维数组中的元素即可
 */
public class No_054_Spiral_Matrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix.length == 0){
			return list;
		}
		int start = 0;
		int length = matrix[0].length-1; //矩阵列数
		int high = matrix.length-1; //矩阵的行数
		while (start<=length && high>=start){
			for (int i=start;i<length;i++){
				int a = matrix[start][i];
				list.add(matrix[start][i]);
			}
			for (int i=start;i<=high;i++){
				list.add(matrix[i][length]);
			}
			if (high!=0){
				for (int i=length-1;i>start;i--){
					list.add(matrix[high][i]);
				}
			}
			if (start!=length){
				for (int i=high;i>start;i--){
					list.add(matrix[i][start]);
				}
			}
			start++;
			length--;
			high--;
		}
		return list;
	}
}
