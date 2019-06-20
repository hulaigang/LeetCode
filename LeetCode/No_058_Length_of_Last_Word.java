package LeetCode;

public class No_058_Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
		if (s.equals("")){
			return 0;
		}
		s.trim();
		char[] c = s.toCharArray();
		int l = 0;
		int last = 0;
		for (int i=0;i<c.length;i++){
			if (c[i]!=' '){
				l++;
				last = l;
			}else {
				l = 0;
			}
		}
		return last;
	}
}
