package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归遍历所有可能，每次使用一个数就将他从候选列表中移除
 */
public class No_046_Permutations {
	public List<List<Integer>> permute(int[] nums) {
		if (nums.length==0){
			return null;
		}
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int i=0;i<nums.length;i++){
			list.add(nums[i]);
		}
		digui(lists,list,"");
		return lists;
	}

	public void digui(List<List<Integer>> lists,List<Integer> list,String s){
		if (list.size()==0){
			List<Integer> list1 = new ArrayList<>();
			String[] c = s.split(",");
			for (int i=1;i<c.length;i++){
				list1.add(Integer.parseInt(c[i]));
			}
			lists.add(list1);
		}else {
			for (int i=0;i<list.size();i++){
				List<Integer> list1 = new ArrayList<>();
				list1.addAll(list);
				list1.remove(i);
				digui(lists,list1,s+","+list.get(i));
			}
		}
	}
}
