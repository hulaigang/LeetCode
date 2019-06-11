package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对于有重复元素存在的全组合，每次递归都只遍历重复元素的最右侧元素
 */
public class No_047_Permutations_II {
	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length==0){
			return null;
		}
		Arrays.sort(nums);
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int i=0;i<nums.length;i++){
			list.add(nums[i]);
		}
		digui(lists,list,"");
		return lists;
	}

	public static void digui(List<List<Integer>> lists,List<Integer> list,String s){
		if (list.size()==0){
			List<Integer> list1 = new ArrayList<>();
			String[] c = s.split(",");
			for (int i=1;i<c.length;i++){
				list1.add(Integer.parseInt(c[i]));
			}
			lists.add(list1);
		}else {
			for (int i=0;i<list.size();i++){
				while (i<list.size()-1 && list.get(i)==list.get(i+1)){
					i++;
				}
				List<Integer> list1 = new ArrayList<>();
				list1.addAll(list);
				list1.remove(i);
				digui(lists,list1,s+","+list.get(i));
			}
		}
	}
}
