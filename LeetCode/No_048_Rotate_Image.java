package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个n*n的二维数组，可以视作由n-1个正方形嵌套而成。按层来旋转二维数组
 * 每一层正方形的旋转可以分为两步：
 * 		第一步：旋转四个顶点
 * 		第二步：旋转每条边上除了顶点以外的点
 */
public class No_048_Rotate_Image {
	public void rotate(int[][] matrix) {
		if (matrix.length==0){
			return;
		}
		int k = 0;
		int l = matrix.length-1;
		while (k<l){
			int temp1 = matrix[k][l];
			matrix[k][l] = matrix[k][k];
			int temp2 = matrix[l][l];
			matrix[l][l] = temp1;
			temp1 = matrix[l][k];
			matrix[l][k] = temp2;
			matrix[k][k] = temp1; //交换4个顶点的坐标
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			for (int i=1;k+i<l;i++){
				list1.add(matrix[k][k+i]);
				matrix[k][k+i] = matrix[l-i][k];
			}
			for (int i=1;k+i<l;i++){
				list2.add(matrix[k+i][l]);
				matrix[k+i][l] = list1.get(i-1);
			}
			list1.clear();
			for (int i=1;l-i>k;i++){
				list1.add(matrix[l][l-i]);
				matrix[l][l-i] = list2.get(i-1);
			}
			list2.clear();
			for (int i=1;l-i>k;i++){
				matrix[l-i][k] = list1.get(i-1);
			}
			k++;
			l--;
		}
	}
}
