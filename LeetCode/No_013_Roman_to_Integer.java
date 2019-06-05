package LeetCode;

/**
 * 当i处的字符小于i+1处的字符时，该为子符代表的数字需要减去
 */
public class No_013_Roman_to_Integer {
	public int romanToInt(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		int sum = 0;
		for (int i=0;i<n;i++){
			if (i==n-1){
				sum += intToRomanOne(c[i]);
			}else {
				if (intToRomanOne(c[i])<intToRomanOne(c[i+1])){
					sum -= intToRomanOne(c[i]);
				}else {
					sum += intToRomanOne(c[i]);
				}
			}
		}
		return sum;
	}

	public int intToRomanOne(char c) {
		switch (c){
			case 'M':
				return 1000;
			case 'D':
				return 500;
			case 'C':
				return 100;
			case 'L':
				return 50;
			case 'X':
				return 10;
			case 'V':
				return 5;
			case 'I':
				return 1;
			default:
				return 0;

		}
	}
}
