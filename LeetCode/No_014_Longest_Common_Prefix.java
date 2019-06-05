package LeetCode;

/**
 * 时间复杂度O(N^2)
 */
public class No_014_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs==null || strs.length==0) return "";
		if (strs.length==1) return strs[0];
		StringBuilder builder = new StringBuilder();
		int i=0;
		a:while (true){
			Character c = null;
			for (int j=0;j<strs.length;j++){
				if (strs[j].length()<=i) break a;
				if (c==null) c=strs[j].charAt(i);
				if (strs[j].charAt(i)!=c) break a;
			}
			builder.append(c);
			i++;
		}
		return builder.toString();
	}
}
