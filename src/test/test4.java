package test;

/**
 * @author yuyang
 * @create 2019-08-18 16:21
 */
public class test4 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,1};
        int[] dp = fun(arr);
        int max = 0;
        int n = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > max){
                max = dp[i];
                n = i;
            }
        }
        //从dp往前找

        System.out.println(max);
    }
    public static int[] fun(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for (int i = 2; i < arr.length; i++) {
                if(i >= 3)
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i]);
                else
                    dp[i] = dp[i - 2] + arr[i];
        }
        return dp;
    }
}
