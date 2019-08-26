package sword.DP;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-20 19:30
 */
/**
 5 8
 2 2 6 5 4
 6 3 5 4 6
 */
public class a经典01背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            v[j] = sc.nextInt();
        }
        System.out.println(fun(m, n, w, v));
    }

    public static int fun(int m, int n, int w[], int v[]) {
        //c[i][m] 表示前i件物品恰好放入重量为m的背包时的最大价值
        int dp[][] = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 0;
            for (int j = 1; j < m + 1; j++) {
                dp[0][j] = 0;
                if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - w[i - 1]] + v[i - 1]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
