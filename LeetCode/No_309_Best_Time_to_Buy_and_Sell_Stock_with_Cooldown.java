package LeetCode;

/**
 * 递归解法的时间复杂度不满足要求，使用动态规划来解
 *  对于任意一天来说 有3种状态：买入、卖出、冷却，因此使用3个数组来记录动态规划的结果
 *  	buy操作需要从总收益中扣除该次价格，sell操作会获得等同于当天价格的收入
 */
public class No_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	public int maxProfit(int[] prices) {
		if (prices==null || prices.length==0 || prices.length==1) return 0;
		int[] buy = new int[prices.length];
		buy[0] = -prices[0];
		int[] sell = new int[prices.length];
		int[] colddown = new int[prices.length];
		for (int i=1;i<prices.length;i++){
			buy[i] = Math.max(colddown[i-1]-prices[i],buy[i-1]);
			sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
			colddown[i] = Math.max(Math.max(sell[i-1],buy[i-1]),colddown[i-1]);
		}
		return sell[prices.length-1];
	}
	//递归解法 时间复杂度太高
	/*private int max=0;
	private int[] prices;
	public int maxProfit(int[] prices) {
		this.prices = prices;
		for (int i=0;i<prices.length;i++){
			digui(i,0);
		}
		return max;
	}

	private void digui(int index,int income){
		if (index>=prices.length){
			max = Math.max(income,max);
			return;
		}else {
			int in = prices[index];
			for (int i=index;i<prices.length;i++){
				if (prices[i]==in) digui(i+1,income);
				else if (prices[i]>in) digui(i+2,income+(prices[i]-in));
			}
			return;
		}
	}*/
}
