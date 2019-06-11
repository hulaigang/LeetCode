package LeetCode;

/**
 *  使用递归解法：
 *  	当指数是偶数时，r^n = r^(n/2)*r^(n/2);
 *  	当指数是奇数时，r^n = r^(n/2)*r^(n/2)*(n>0?x:1/x)
 *  这样每次计算一次pow(r,n/2)即可
 */
public class No_050_Pow {
	public double myPow(double x, int n) {
		return poW(x,n);
	}

	public double poW(double x,int n){
		if (n==0){
			return 1;
		}
		if (n==1){
			return x;
		}
		if (n==-1){
			return 1/x;
		}
		if (n%2==0){
			double r = poW(x,n/2);
			return r*r;
		}else {
			double r = poW(x,n/2);
			return r*r*(n>0?x:1/x);
		}
	}
}
