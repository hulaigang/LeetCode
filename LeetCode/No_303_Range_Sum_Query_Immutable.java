package LeetCode;

/**
 * 一开始没有理解题目，题目的意思应该是对于一个固定的数组 多次调用函数求解指定索引区间内所有元素的和，由于调用次数很多，因此对时间复杂度有要求
 * 使用动态规划的思想，使用一个与原始数组等长的数组，新数组中的n[i]表示原数组中下标从0到i的所有元素之和
 */
public class No_303_Range_Sum_Query_Immutable {
	private Integer[] sums;
	private int[] nums;
	public No_303_Range_Sum_Query_Immutable(int[] nums) {
		this.nums = nums;
		sums = new Integer[nums.length];
	}

	public int sumRange(int i, int j) {
		if (sums[i]==null){
			int sum = 0;
			for (int k=0;k<=i;k++){
				sum += nums[k];
			}
			sums[i] = sum;
		}
		if (sums[j]==null){
			int sum = 0;
			for (int k=0;k<=j;k++){
				sum += nums[k];
			}
			sums[j] = sum;
		}
		return sums[j]-sums[i]+nums[i];
	}
}
