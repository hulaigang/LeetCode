package LeetCode;

/**
 * 时间复杂度O（N），初始化一个指向数组尾端的指针，遍历数组，遇到指定元素，就将该元素与最后面的一个元素交换，并将指针前移一位
 */
public class No_027_Remove_Element {
	public int removeElement(int[] nums, int val) {
		int n = nums.length-1; //从最后开始的交换坐标
		if (nums.length==0){
			return 0;
		}
		for (int i=0;i<=n;i++){
			while (n>=0 && nums[n]==val){
				n--;
			}
			if (n==i && nums[i] == val){
				n--;
				break;
			}
			if (nums[i]==val && i<n){
				int temp = nums[n];
				nums[n] = nums[i];
				nums[i] = temp;
				n--;
			}
		}
		return n+1;
	}
}
