package sword.DP;

/**
 * 和换钱最少货币数条件一样，求的是有多少种组成方法
 *给一个数组，arr={5,10,25,1}，一个目标数aim=15,数组中数字使用次数不限，有多少种组成目标数的方法。
 * @author yuyang
 * @create 2019-08-14 16:20
 */
public class b换钱的方法数 {

    public static int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        //dp[i][j]:使用前i个数组，组成j有多少种方法
        int[][] dp = new int[arr.length][aim + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        //第一个数只能组成这个数的倍数
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                //当前数使用0-k次的总和
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static void main(String[] args) {
        int[] coins = {10, 5, 1, 25};
        int aim = 2000;
        long start = 0;
        long end = 0;
        System.out.println("=====动态规划O(N*(aim^2))的方法=====");
        start = System.currentTimeMillis();
        System.out.println(coins3(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");
        }
}
