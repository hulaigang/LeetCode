package LeetCode;

/**
 * 与303题类似，此题中原数组会发生变化，在原数组更新的同时更新动态规划数组的值即可
 */
public class No_307_Range_Sum_Query_Mutable {
	private int[] nums; //原始数组
	private int[] sums; //动态规划，记录前i个数之和的数组
	public No_307_Range_Sum_Query_Mutable(int[] nums) {
		this.nums = nums;
		sums = new int[nums.length];
		for (int i=0;i<sums.length;i++){
			sums[i] = nums[i];
			if (i>0){
				sums[i] += sums[i-1];
			}
		}
	}

	public void update(int i, int val) {
		int n = nums[i]-val;
		nums[i] = val;
		for (int j=i;j<sums.length;j++){
			sums[j] -= n;
		}
	}

	public int sumRange(int i, int j) {
		return sums[j]-sums[i]+nums[i];
	}
}
