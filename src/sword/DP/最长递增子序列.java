package sword.DP;

/**
 * @author yuyang
 * @create 2019-08-14 15:54
 */
public class 最长递增子序列 {

    public static int[] lis1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }

    /**
     * dp[i]:以arr[i]结尾的arr[0...i]中最大递增子序列长度
     * 注：dp[0] = 1,其他：dp[i] = max{dp[j] + 1(arr[j] < arr[i])}
     * @param arr
     * @return
     */
    public static int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //第一个为1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        //遍历dp数组找出最大值与位置
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        //第一个数就确定了
        int[] lis = new int[len];
        lis[--len] = arr[index];
        //往左遍历，如果arr[i] < arr[index] && dp[i] == dp[index] - 1，就可以作为下一个
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    public static int[] lis2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp2(arr);
        return generateLIS(arr, dp);
    }

    public static int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
       // int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int arr[] = {1,2,1,3,4};
        lis1(arr);
        printArray(arr);
      //  printArray(lis1(arr));
      //  printArray(lis2(arr));

    }
}