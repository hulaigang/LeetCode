package LeetCode;

import java.util.HashMap;

/**
 * 时间复杂度O（N）
 */
public class No_003_Longest_Substring_Without_Repeating_Characters {
	public int lengthOfLongestSubstring(String s) {
		if (s==null || s.equals("")) return 0;
		if (s.length()==1) return 1;
		char[] c = s.toCharArray();
		int max_length=0,length=0,i=0;
		HashMap<Character,Integer> map = new HashMap<>();
		while (i<c.length){
			length = 0;
			map.clear();
			while (i<c.length && (!map.containsKey(c[i]))){
				length++;
				map.put(c[i],i);
				i++;
			}
			max_length = Math.max(max_length,length);
			if (i>=c.length) break;
			i = map.get(c[i])+1;
		}
		return max_length;
	}
}
