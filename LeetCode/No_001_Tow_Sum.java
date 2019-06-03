package LeetCode;

/**
 * 时间复杂度O（N^2）
 */
public class No_1_Tow_Sum {
	public int[] twoSum(int[] nums, int target) {
		int[] sum = new int[2];
		for(int i=0;i<nums.length;i++){
			int a = target-nums[i];
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]==a){
					sum[0] = i;
					sum[1] = j;
				}
			}
		}
		return sum;
	}
}
