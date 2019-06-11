package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 同第39题，只不过每次递归都将范围缩小到当前元素的右边，不包括当前元素
 */
public class No_040_Combination_Sum_II {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length==0){
			return null;
		}
		Arrays.sort(candidates);
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		digui(lists,"#",target,candidates,0);
		return lists;
	}

	public static void digui(List<List<Integer>> lists,String s,int n,int[] candidates,int start){
		if (n<0) {
			return;
		}else if (n==0){
			String[] c = s.split(",");
			List<Integer> list = new ArrayList<>();
			for (int i=1;i<c.length;i++){
				list.add(Integer.parseInt(c[i]));
			}
			lists.add(list);
			return;
		}else {
			for (int i=start;i<candidates.length;i++){
				digui(lists,s+","+candidates[i],n-candidates[i],candidates,i+1);
				while (i<candidates.length-1 && candidates[i+1]==candidates[i])
					i++;
			}
		}
	}
}
