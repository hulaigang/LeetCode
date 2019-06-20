package LeetCode;

/**
 * 从倒数第二个元素开始向前遍历，如果当前并不断累积距离
 * 当遍历到的元素的步长大于累积的距离时，说明从该店可以到达指定目标点
 * 这时将距离清零，再向前遍历找能到达该点的点，直到到达数组的第一个元素
 */
public class No_055_Jump_Game {
	public boolean canJump(int[] nums) {
		int n = 1;
		for (int i=nums.length-2;i>-1;i--){
			if (nums[i]>=n){
				n=1;
			}else {
				n++;
			}
		}
		if (n==1){
			return true;
		}else {
			return false;
		}
	}
}
