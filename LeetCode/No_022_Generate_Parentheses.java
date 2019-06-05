package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 记录左括号和右括号的数量，当右括号的数量大于左括号的数量时，有两种办法：
 * ①继续添加一个左括号
 * ②立即添加一个右括号与之对应
 */
public class No_022_Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		digui(list,"",n,n);
		return list;
	}

	public void digui(List<String> list,String s,int left,int right){
		if (left==0&&right==0){
			list.add(s);
			return;
		}
		if (left>0){
			digui(list,s+"(",left-1,right);
		}

		if (right>left){
			digui(list,s+")",left,right-1);
		}

	}
}
