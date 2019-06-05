package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 同3个数求和
 */
public class No_018_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> lists = new ArrayList<>();
		for(int i=0;i<n-3;i++){
			if (i==0 || (i>0 && nums[i]!=nums[i-1])){
				for (int j=i+1;j<n-2;j++){
					int k=j+1,l=n-1;
					while (k<l){
						if (nums[i]+nums[j]+nums[k]+nums[l] == target){
							lists.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
							while (j<n-2&&nums[j]==nums[j+1])
								j++;
							while (k<l&&nums[k]==nums[k+1])
								k++;
							while (k<l&&nums[l]==nums[l-1])
								l--;
							k++;
							l--;
						}else if (nums[i]+nums[j]+nums[k]+nums[l] < target){
							k++;
						}else if (nums[i]+nums[j]+nums[k]+nums[l] > target){
							l--;
						}
					}
				}
			}
		}
		return lists;
	}
}
