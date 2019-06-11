package LeetCode;

import java.util.Arrays;

/**
 * 这题自己一开始没做出来，看的答案，大致的算法思路是：
 * 		从低位向高位遍历，直到找到一个num[i]<num[i+1]，然后将num[i]与num[i+1]到num[num.length-1]中大于num[i]的最小的一个元素交换，
 * 		然后再将num[i+1]到num[num.length-1]的元素按照升序排序，即可得到
 */
public class No_031_Next_Permutation {
	public void nextPermutation(int[] nums) {
		if (nums.length==0){
			return;
		}
		for (int i=nums.length-1;i>0;i--){
			if (nums[i]>nums[i-1]){
				int min = nums[i];
				int k = i;
				for (int j=i;j<nums.length;j++){
					if (nums[j]>nums[i-1]){
						if (min>=nums[j]){
							min = nums[j];
							k = j;
						}
					}
				}
				int temp = nums[k];
				nums[k] = nums[i-1];
				nums[i-1] = temp;
				for (int j=i;j<=i+(nums.length-1-i)/2;j++){
					int tem = nums[j];
					nums[j] = nums[nums.length-1-(j-i)];
					nums[nums.length-1-(j-i)] = tem;
				}
				return;
			}
		}
		Arrays.sort(nums);
		return;
	}
}
