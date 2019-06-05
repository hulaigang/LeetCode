package LeetCode;

/**
 * 时间复杂度O（N），使用双指针，一个指针用来遍历数组，一个指针记录非重复元素的最右位置
 */
public class No_026_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		if (nums==null || nums.length==0) return 0;
		if (nums.length==1) return 1;
		int now=0,index=0;
		while (index<nums.length){
			while (index<nums.length-1 && nums[index]==nums[index+1]) index++;
			nums[now] = nums[index];
			index++;
			now++;
		}
		return now;
	}
}
