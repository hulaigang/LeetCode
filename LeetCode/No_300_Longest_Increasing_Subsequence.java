package LeetCode;

/**
 * 时间复杂度O（N^2），动态规划，从后往前遍历数组，维护一个数组，表示从第i位开始的最大子串长度
 * 然后从i开始，当i小于其后的任意一位数时，就可以继承该位的最长子串长度
 */
public class No_300_Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums==null || nums.length==0) return 0;
		if (nums.length==1) return 1;
		int[] length = new int[nums.length];
		int max_length = 1;
		length[length.length-1] = 1;
		for (int i=length.length-2;i>=0;i--){
			int now_length = 1;
			for (int j=i+1;i<length.length;j++){
				if (nums[j]>nums[i]){
					now_length = Math.max(now_length,length[j]+1);
				}
			}
			length[i] = now_length;
			max_length = Math.max(max_length,now_length);
		}
		return max_length;
	}
}
