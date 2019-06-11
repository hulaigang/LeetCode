package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 首先根据两个乘数的位数得出积的最大位数，并得出竖乘式中小乘式的个数，填充到二维矩阵中，然后从上向下遍历二维矩阵，求各个乘式的和即可得到积
 * 	0 1 2 3 4
 *
 *                         1 2 3
 *                     *     4 5
 *                     ---------
 *                      0 0 0 1 5
 *                      0 0 1 0 0
 *                      0 0 5 0 0
 *                     ----------
 *                      0 0 6 1 5
 *                      0 0 1 2 0
 *                      0 0 8 0 0
 *                      0 4 0 0 0
 *                     ---------
 *                     0 5 5 3 5
 */
public class No_043_Multiply_Strings {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")){
			return "0";
		}
		char[] c1;
		char[] c2;
		if (num1.length()>=num2.length()){
			c1 = num1.toCharArray();
			c2 = num2.toCharArray();
		}else {
			c1 = num2.toCharArray();
			c2 = num1.toCharArray();
		}
		int l1 = c1.length-1;
		int l2 = c2.length-1;
		List<int[]> lists = new ArrayList<>();
		for (int i=l2;i>-1;i--){
			List<int[]> list = new ArrayList<>();
			for (int j=l1;j>-1;j--){
				int a = (c1[j]-'0')*(c2[i]-'0');
				int[] n = new int[c1.length+c2.length];
				n[i+j+1]=a%10;
				n[i+j]=a/10;
				list.add(n);
			}
			int jinwei=0;
			int[] a = new int[c1.length+c2.length];
			for (int j=a.length-1;j>-1;j--){
				int sum = 0;
				for (int k=0;k<list.size();k++){
					sum+=(list.get(k))[j];
				}
				sum+=jinwei;
				if (sum>=10){
					a[j] = sum%10;
					jinwei = sum/10;
				}else {
					a[j] = sum;
					jinwei = 0;
				}
			}
			lists.add(a);
		}
		int jinwei=0;
		int[] a = new int[c1.length+c2.length];
		for (int j=a.length-1;j>-1;j--){
			int sum = 0;
			for (int k=0;k<lists.size();k++){
				sum+=(lists.get(k))[j];
			}
			sum+=jinwei;
			if (sum>=10){
				a[j] = sum%10;
				jinwei = sum/10;
			}else {
				a[j] = sum;
				jinwei = 0;
			}
		}
		int i=0;
		StringBuilder builder = new StringBuilder("");
		while (a[i]==0)
			i++;
		for (int j=i;j<a.length;j++){
			builder.append(String.valueOf(a[j]));
		}
		return builder.toString();
	}
}
