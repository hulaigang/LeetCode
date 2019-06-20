package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * [1,.....,n]一共有n！种排列
 * 这样，以其中一个元素开头的排列有n!/n种，这样不断取余，找到目标位置的排列
 */
public class No_060_Permutation_Sequence {
	public String getPermutation(int n, int k) {
		StringBuilder builder = new StringBuilder("");
		List<Integer> list = new ArrayList<>();
		for (int i=0;i<n;i++){
			list.add(i+1);
		}
		k=k-1;
		for (int i=n-1;i>=0;i--){
			if (i==0){
				builder.append(list.get(0));
			}else {
				int a = k/jiecheng(i);
				builder.append(list.get(a));
				list.remove(a);
				k = k%jiecheng(i);
			}
		}
		return builder.toString();
	}

	public int jiecheng(int n){
		if (n==0) return 1;
		int i=1;
		for (int j=n;j>0;j--){
			i *= j;
		}
		return i;
	}
}
