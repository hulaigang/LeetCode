package LeetCode;

import java.util.Arrays;

/**
 * 同第15题，先遍历，在对元素右侧元素使用双指针
 */
public class No_016_3Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int max_jiejin=Integer.MAX_VALUE;
		int max = 0;
		a1:for(int i=0;i<nums.length-2;i++){
			if(i==0||(i>0 && nums[i]!=nums[i-1])){
				int j=i+1,k=nums.length-1;
				while (j<k){
					int a = nums[i]+nums[j]+nums[k];
					int x = Math.abs(a-target);
					if (x<max_jiejin){
						max_jiejin = x;
						max = a;
					}
					//while (j<k && nums[j]==nums[j+1])
					// j++;
					// while (j<k && nums[k]==nums[k-1])
					//k--;
					if (a<target){
						j++;
					}else if(a>target){
						k--;
					}else {
						break a1;
					}
				}
			}
		}
		return max;
	}
}
