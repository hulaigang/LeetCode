package LeetCode;

/**
 * 时间复杂度O（N），使用双指针思想，矩形的高度以两条边中较短的一条为准，并将较短一边的指针向中间移动
 */
public class No_011_Container_With_Most_Water {
	public int maxArea(int[] height) {
		if (height==null || height.length<=1) return -1;
		int max = 0,left=0,right=height.length-1;
		while (left<right){
			int h = Math.min(height[left],height[right]);
			max = Math.max(h*(right-left),max);
			if (height[left]<=height[right]) left++;
			else right--;
		}
		return max;
	}
}
