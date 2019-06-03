package LeetCode;

import java.util.ArrayList;

public class No_008_String_to_Integer {
	public int myAtoi(String str) {
		String s = str.trim();
		if (s.equals("")){
			return  0;
		}else {
			char[] c = s.toCharArray();
			boolean is_num = false;
			ArrayList<Character> list = new ArrayList<Character>();
			if((c[0]>='0'&&c[0]<='9')||(c[0]=='+' || c[0]=='-')){
				for(int i=0;i<c.length;i++){
					if(c[i]>='0'&&c[i]<='9'){
						list.add(c[i]);
						is_num = true;
					}else if(c[i]=='+' || c[i]=='-'){
						if (is_num){
							break;
						}else {
							if (i==c.length-1){
								return 0;
							}else {
								if(c[i+1]>='0'&&c[i+1]<='9'){
									list.add(c[i]);
								}else {
									return 0;
								}
							}
						}
					}else {
						break;
					}
				}
				int t=0;
				for (int i=0;i<list.size();i++){
					if (c[i]>='0'&&c[i]<='9'){
						t = i;
						break;
					}
				}
				boolean zhengfu =false;
				for (int i=0;i<t;i++){
					if (list.get(i)=='-'){
						zhengfu = !zhengfu;
					}
				}
				long num = 0;
				for (int i=0;t+i<list.size();i++){
					num += (list.get(t+i)-'0')*Math.pow(10,list.size()-t-1-i);
				}
				if(zhengfu){
					num = -num;
				}
				if (num<Integer.MAX_VALUE && num>Integer.MIN_VALUE){
					return ((int)num);
				}else if(num >= Integer.MAX_VALUE){
					return Integer.MAX_VALUE;
				}else {
					return Integer.MIN_VALUE;
				}
			}else {
				return 0;
			}
		}
	}
}
