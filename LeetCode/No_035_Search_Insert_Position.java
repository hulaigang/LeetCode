package LeetCode;

/**
 * 二分查找，在无法查找到指定值时，根据最后查找到的与目标值最接近的元素与查找值的关系返回索引值
 */

public class No_035_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		if (nums.length==0){
			return 0;
		}
		int left=0,right=nums.length-1;
		while (left<=right){
			if (left==right){
				if (nums[left]<target) return left+1;
				else if (nums[left]>target) return left;
			}
			int mid = (left+right)/2;
			if (nums[mid]==target) return mid;
			else if (nums[mid]<target) left=((mid+1<nums.length)?mid+1:nums.length-1);
			else right=((mid-1<0)?0:mid-1);
		}
		return left;
	}
}
