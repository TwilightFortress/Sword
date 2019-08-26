package others;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-18 16:42
 */
public class aaatest5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = fun(nums);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] fun(int[] arr) {
        int[] res = new int[2];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++){
            int cur1 = dp[i - 2] + arr[i];
            int cur2 = dp[i - 1];
            dp[i] = Math.max(cur1, cur2);
        }

        res[0] = dp[arr.length - 1];
        int max = res[0];
        int len = arr.length;
        int num = 0;
        for(int i = len - 1; i >= 0; i--){
            while(dp[i] == max ){
                i--;
                if(i == -1)
                    break;
            }
            i = i +1;
            num++;
            max = dp[i] - arr[i];
            i = i -1;
        }
        res[1] = num;
        return res;

    }
}
