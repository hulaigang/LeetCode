package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 时间复杂度O（N）
 */
public class No_007_Reverse_Integer {
	public int reverse(int x) {
		int x_s = Math.abs(x);
		Queue<Integer> queue = new LinkedList<>();
		while (x_s!=0){
			queue.add(x_s%10);
			x_s/=10;
		}
		long sum = 0;
		while (!queue.isEmpty()){
			int i = queue.poll();
			sum+=i*Math.pow(10,queue.size());
		}
		sum = x<0?(-sum):sum;
		if (sum<Integer.MIN_VALUE ||sum>Integer.MAX_VALUE) return 0;
		return (int)sum;
	}
}
