package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 同分异构词将各位字符按序排列后的结果是一样的，用这个方法来判断同分异构词
 * 另外提供一个大神的解法：
 * 		将26个小写字母使用26个不同的质数编码，这样一来，同分异构词各个位置上字符对应的质数的积是一致的
 */
public class No_049_Group_Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String,List<String>> map = new HashMap<>();
		a1:for (int i=0;i<strs.length;i++){
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String s = String.valueOf(c);
			if (map.containsKey(s)){
				map.get(s).add(strs[i]);
			}else {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				map.put(s,list);
			}
		}
		List<List<String>> lists = new ArrayList<>(map.values());
		return lists;
	}
}
