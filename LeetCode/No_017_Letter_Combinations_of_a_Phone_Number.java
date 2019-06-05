package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 利用Map建立按键和字母的一对多关系，利用递归进行完全遍历
 */
public class No_017_Letter_Combinations_of_a_Phone_Number {
	public List<String> letterCombinations(String digits) {
		char[] c = digits.toCharArray();
		List<String> list = new ArrayList<>();
		if (c.length==0){
			return list;
		}
		HashMap<Character,List<String>> map = new HashMap<>();
		map.put('2', Arrays.asList("a","b","c"));
		map.put('3',Arrays.asList("d","e","f"));
		map.put('4',Arrays.asList("g","h","i"));
		map.put('5',Arrays.asList("j","k","l"));
		map.put('6',Arrays.asList("m","n","o"));
		map.put('7',Arrays.asList("p","q","r","s"));
		map.put('8',Arrays.asList("t","u","v"));
		map.put('9',Arrays.asList("w","x","y","z"));
		list = link(c,0,list,"",map);
		return list;
	}

	public List<String> link(char[] c,int i,List<String> list,String s,HashMap<Character,List<String>> map){
		if (i==c.length-1){
			List<String> list1 = map.get(c[i]);
			for (int j=0;j<list1.size();j++){
				list.add(s+list1.get(j));
			}
			return list;
		}else {
			List<String> list1 = map.get(c[i]);
			for (int j=0;j<list1.size();j++){
				list = link(c,i+1,list,s+list1.get(j),map);
			}
			return list;
		}
	}
}
