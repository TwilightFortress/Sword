package others;

public class 股票 {
	
	public static void main(String[] args) {
		int[] prices = {1,3,2,8,4,9};
		int	fee = 2;
		System.out.println(fun( prices,fee));
	}
	private static int fun(int [] prices, int fee) {
		 
		int s = 0,h = -prices[0]; 
		for (int i = 1; i < prices.length; i++) {
			s = Math.max(s,h + prices[i] - fee); 
			h = Math.max(h,s - prices[i]); 
		} 
		return s;
	}
}
