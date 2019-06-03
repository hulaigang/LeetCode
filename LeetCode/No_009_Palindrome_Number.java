package LeetCode;

/**
 * 时间复杂度O（N）
 */
public class No_009_Palindrome_Number {
	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		char[] c = s.toCharArray();
		for(int i=0;i<c.length/2;i++){
			if(c[i]==c[c.length-1-i]){

			}else {
				return false;
			}
		}
		return true;
	}
}
