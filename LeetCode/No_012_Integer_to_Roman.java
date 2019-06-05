package LeetCode;

/**
 * 转换格则是将整数拆成其各个位数的和，例如：1994=1000+900+90+4
 * 对每一位的数进行罗马数字转换即可
 */
public class No_012_Integer_to_Roman {
	public String intToRoman(int num) {
		String s = String.valueOf(num);
		char[] c = s.toCharArray();
		int n = c.length;
		StringBuilder builder = new StringBuilder("");
		for (int i=0;i<n;i++){
			int a = (int)((c[i]-'0')*Math.pow(10,n-1-i));
			String s1 = intToRomanOne(a);
			builder.append(s1);
		}

		return builder.toString();
	}

	public String intToRomanOne(int num) {
		switch (num){
			case 4:
				return "IV";
			case 9:
				return "IX";
			case 40:
				return "XL";
			case 90:
				return "XC";
			case 400:
				return "CD";
			case 900:
				return "CM";
			default:
				StringBuilder builder = new StringBuilder("");
				if(num>=1000){
					for(int i=0;i<num/1000;i++){
						builder.append("M");
					}
				}else if(num>=100){
					if(num>=500){
						builder.append("D");
						for (int i=0;i<(num-500)/100;i++){
							builder.append("C");
						}
					}else {
						for (int i=0;i<num/100;i++){
							builder.append("C");
						}
					}
				}else if (num>=10){
					if(num>=50){
						builder.append("L");
						for (int i=0;i<(num-50)/10;i++){
							builder.append("X");
						}
					}else {
						for (int i=0;i<num/10;i++){
							builder.append("X");
						}
					}
				}else if (num>=0){
					if(num>=5){
						builder.append("V");
						for (int i=0;i<num-5;i++){
							builder.append("I");
						}
					}else {
						for (int i=0;i<num;i++){
							builder.append("I");
						}
					}
				}
				return builder.toString();
		}
	}
}
