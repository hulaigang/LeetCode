package LeetCode;

/**
 * 经典算法题，该题主流解法有3种，分别为：中心扩展法、动态规划、马拉车算法。
 */
public class No_005_Longest_Palindromic_Substring {
	/**
	 * 时间复杂度O（N^2）
	 * 第一种解法：动态规划。
	 * 用二维数组来作为记录，d[i][j]代表字符串中从i到j为止的子串是不是回文串。这时需分成三种情况考虑：
	 * ①当i==j时，子串长度为1，一定是回文串；
	 * ②当|j-i|==1时，子串长度为2，若字符串中i索引处的字符与j索引处字符相同，则是回文串，否则则不是；
	 * ③当|j-i|>1时，为回文串的充要条件是i处字符等于j处，且d[i+1][j-1]为回文串
	 */
	public String longestPalindrome_1(String s) {
		if (s==null || s.equals("")) return "";
		if (s.length()==1) return s;
		String max_s = s.substring(0,1);
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int j=0;j<s.length();j++){
			dp[j][j] = true;
			for (int i=0;i<j;i++){
				if (j==i) dp[i][j] = true;
				else if (j-i==1) dp[i][j] = (s.charAt(i)==s.charAt(j));
				else if (j-i>1) dp[i][j] = (s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
				if (dp[i][j] && (j-i+1)>max_s.length()) max_s = s.substring(i,j+1);
			}
		}
		return max_s;
	}

	/**
	 * 时间复杂度O(N^2)
	 * 第二种解法：中心扩展法
	 * 思路是以每个元素为中心，像两端扩展，直到找到每个元素为中心的最长回文串，再取其中的最长长度，此处需要注意的时，扩展方式需要分为奇数和偶数两种
	 */
	public String longestPalindrome_2(String s) {
		if (s==null || s.equals("")) return "";
		if (s.length()==1) return s;
		String max_s = s.substring(0,1);
		//奇数长度扩散，以单个元素为中心
		for(int i=0;i<s.length();i++){
			int left = i-1,right=i+1;
			while (left>-1 && right<s.length() && (s.charAt(left)==s.charAt(right))){
				if (right-left+1>max_s.length()){
					max_s = s.substring(left,right+1);
				}
				left--;
				right++;
			}
		}

		//偶数长度扩散，以元素和他右侧元素为中心
		for (int i=0;i<s.length();i++){
			int left=i,right=i+1;
			while (left>-1 && right<s.length() && (s.charAt(left)==s.charAt(right))){
				if (right-left+1>max_s.length()){
					max_s = s.substring(left,right+1);
				}
				left--;
				right++;
			}
		}
		return max_s;
	}

	/**
	 * 时间复杂度O（N）
	 * 第三种解法：马拉车算法
	 * 他是中心扩展法的一种改进算法，改进点主要在于：
	 * ①他通过在字符串的每个字符两端添加一个补充字符（这里使用字符#），解决了奇数偶数不同的情况；然后再在字符串最前端添加一个移位字符（这里使用$），将所有字符的位置后移一位。扫描所有
	 * 	 字符，找到以他们为中心的最长回文串半径L，则对于原始字符串，最长回文子串直径为L-1，起始位置为最长半径对于中心点的索引减去L，再除以2；
	 * ②他通过记录当前最大半径对应的中心坐标，这样，以最大半径内、位于中心点右端任意一点为中心的回文半径最短为其关于中心点对称的左测点的最大半径
	 * 具体参加：https://www.cnblogs.com/grandyang/p/4475985.html
	 */
	public String longestPalindrome_3(String s) {
		if (s==null || s.equals("")) return "";
		if (s.length()==1) return s;
		String t = "$#";
		//构建特殊字符串
		for (int i=0;i<s.length();i++){
			t += s.charAt(i)+"#";
		}
		//利用一位数组记录以每一位原始字符为中心的最大半径
		int[] max_l = new int[s.length()];
		int mr=0,id=0,resLen=0,resCenter=0;//其中mr是目前回文子串能达到的最右端坐标，id为此时的回文子串中心点坐标
		for (int i=1;i<t.length();i++){
			max_l[i] = mr>i?Math.min(max_l[2*id-i],mr-i):1; //该点是否在最大回文串之内，在的话，半径至少为他对应点的半径，否则从1开始
			while (t.charAt(i+max_l[i]) == t.charAt(i-max_l[i])) max_l[i]++;
			if (mr<i+max_l[i]){
				mr = i+max_l[i];
				id = i;
			}
			if (resLen<max_l[i]){
				resLen = max_l[i];
				resCenter = i;
			}
		}
		return s.substring((resCenter-resLen)/2,resLen-1);
	}

}
