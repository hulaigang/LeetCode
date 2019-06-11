package LeetCode;

/**
 * 数中相邻的n个相同的数m，会在下一次报数中以nm的形式报出，使用递归，从“1”开始向上生成
 */
public class No_038_Count_and_Say {
	public String countAndSay(int n) {
		return digui(n);
	}

	public String digui(int n){
		if (n==1){
			return "1";
		}else {
			char[] c = digui(n-1).toCharArray();
			StringBuilder builder = new StringBuilder("");
			int a = 0;
			char ca = c[0];
			for (int i=0;i<c.length;i++){
				if (c[i]==ca){
					a++;
				}else {
					builder.append(a);
					builder.append(ca);
					ca = c[i];
					a = 1;
				}
			}
			builder.append(a);
			builder.append(ca);
			return builder.toString();
		}
	}
}
