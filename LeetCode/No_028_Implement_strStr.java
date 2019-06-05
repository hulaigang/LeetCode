package LeetCode;

/**
 * 时间复杂度O（N^2），遍历原字符串，当首字母相同时开始判断是否每一位都相同
 */
public class No_028_Implement_strStr {
	public int strStr(String haystack, String needle) {
		if (needle.equals("")&& haystack.equals("")){
			return 0;
		}
		if (haystack.equals("")){
			return -1;
		}
		if (needle.equals("")){
			return 0;
		}
		char[] hay = haystack.toCharArray();
		char[] need = needle.toCharArray();
		a1:for (int i=0;i<=hay.length-need.length;i++){
			if (hay[i] == need[0]){
				for (int j=i+1;j-i<need.length;j++){
					if (hay[j]!=need[j-i]){
						continue a1;
					}
				}
				return i;
			}else {
				continue;
			}
		}
		return -1;
	}
}
