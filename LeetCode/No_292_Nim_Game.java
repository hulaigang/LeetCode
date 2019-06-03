package LeetCode;

/**
 * 巴什博弈：一堆有N个物品，两个人轮流从中取出物品，每次取出的数量为1~M个，则当且仅当N%（M+1）==0时，后手能获得胜利，否则，先手必胜
 */
public class No_292_Nim_Game {
	public boolean canWinNim(int n) {
		return n%4==0?false:true;
	}
}
