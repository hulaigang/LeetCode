package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 时间复杂度O（N^2）,将数组从小到大排列，遍历数组，只从当前元素右边找目标元素
 * 对于大于0的元素直接跳过（因为3个非0正数的和不可能是0）
 * 对于多个重复元素，只遍历最右边的重复元素
 * 确定第一个元素后，对于剩下的两个元素，使用双指针法确定
 */
public class No_015_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ls = new ArrayList<>();
		for(int i=0 ;i<nums.length-2;i++){
			if((i==0||i>0&&nums[i]!=nums[i-1])&&nums[i]<=0){
				int l=i+1,r=nums.length-1,sum=0-nums[i];
				while(l<r){
					if(nums[l]+nums[r]==sum){
						ls.add(Arrays.asList(nums[i],nums[l],nums[r]));
						while(l<r&&nums[l]==nums[l+1])
							l++;
						while(l<r&&nums[r]==nums[r-1])
							r--;
						l++;r--;
					}
					else if(nums[l]+nums[r]>sum)
						r--;
					else
						l++;
				}
			}
		}
		return ls;
	}
}
