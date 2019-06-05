package LeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 设计到括号的题基本都和栈有关，遍历字符串，将所有的左括号压入栈中，每次碰到右括号就从栈中弹出一个左括号，看其与右括号是否匹配
 */
public class No_020_Valid_Parentheses {
	public boolean isValid(String s) {
		char[] c= s.toCharArray();
		HashMap<Character,Character> map = new HashMap<>();
		map.put('}','{');
		map.put(')','(');
		map.put(']','[');
		if(c.length==0){
			return true;
		}
		if(c.length%2!=0){
			return false;
		}
		if (c[0]==']' || c[0] == '}' || c[0]==')'){
			return false;
		}

		Stack<Character> stack = new Stack<>();
		for (int i=0;i<c.length;i++){
			if (c[i]=='(' || c[i]=='{' || c[i]=='['){
				stack.push(c[i]);
			}else {
				if (stack.pop()!=map.get(c[i])){
					return false;
				}
			}
		}
		if (stack.size()!=0){
			return false;
		}else {
			return true;
		}
	}
}
