package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 暴力解法，遍历所有可能，对不符合的分支进行剪枝
 * 注意这几个特殊情况：
 *      ①0只能单独作为一个0或者依附在其它非0的数字后面
 *		②构成的整数栈的长度至少为3
 */
public class No_306_Additive_Number {
	private Stack<Long> stack;
	private String num;
	public boolean isAdditiveNumber(String num) {
		stack = new Stack<>();
		this.num = num;
		return digui(0);
	}

	private boolean digui(int index){
		if (num.length()-index+stack.size()<3){
			return false;
		}
		if (index>=num.length()&&stack.size()>2){
			return true;
		}
		if (index>=num.length()){
			return false;
		}
		if (num.charAt(index)=='0'){
			if (stack.size()>=2){
				if (0==stack.get(stack.size()-1)+stack.get(stack.size()-2)){
					stack.push(0L);
					if (digui(index+1)) return true;
					else {
						stack.pop();
					}
				}else {
					return false;
				}
			}else {
				stack.push(0L);
				if (digui(index+1)) return true;
				else {
					stack.pop();
					return false;
				}
			}
		}else {
			for (int l=1;index+l<=num.length();l++){
				Long nums = null;
				try{
					nums = Long.parseLong(num.substring(index,index+l));
				}catch (Exception e){
					return false;
				}
				if (stack.size()>=2){
					if (nums==stack.get(stack.size()-1)+stack.get(stack.size()-2)){
						stack.push(nums);
						if (digui(index+l)) return true;
						else {
							stack.pop();
							continue;
						}
					}else {
						continue;
					}
				}else {
					stack.push(nums);
					if (digui(index+l)) return true;
					else {
						stack.pop();
						continue;
					}
				}
			}
		}
		return false;
	}
}
