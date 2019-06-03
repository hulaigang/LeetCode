package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 时间复杂度O(N)，记录非Bulls数出现的次数
 */
public class No_299_Bulls_and_Cows {
	public String getHint(String secret, String guess) {
		if (secret==null || guess==null) return null;
		int cow_num=0,bulls_num=0;
		int[] cows = new int[10];
		boolean[] b = new boolean[guess.length()];
		for (int i=0;i<secret.length();i++){
			if (secret.charAt(i)==guess.charAt(i)){
				bulls_num++;
				b[i]=true;
			}else {
				cows[secret.charAt(i)-'0']++;
			}
		}
		for (int i=0;i<b.length;i++){
			if (!b[i]){
				if (cows[guess.charAt(i)-'0']>0){
					cow_num++;
					cows[guess.charAt(i)-'0']--;
				}
			}
		}
		return bulls_num+"A"+cow_num+"B";
	}
}
