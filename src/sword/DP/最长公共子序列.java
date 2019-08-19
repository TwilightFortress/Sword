package sword.DP;

/**
 * 子序列，在字符串中不必连续
 * str1 = 1A2C3S4B56
 * str2 = B1D23CA45B6A
 * 公共子序列：123456、12C4B6
 *
 * @author yuyang
 * @create 2019-08-11 9:07
 */
public class 最长公共子序列 {

    public static String lcse(String str1, String str2) {
        //边界
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int m = chs1.length - 1;
        int n = chs2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    public static int[][] getdp(char[] str1, char[] str2) {
        //str1[0...i]与str2[0...j]的最长公共子序列长度
        int[][] dp = new int[str1.length][str2.length];
        //
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        //取str2的第一个，若str1中有与其相等，假设下标为i,那么dp数组中dp[i...m-1][0]都为1,即矩阵第一列
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        //取str1的第一个，str2中有与其相等，假设下标为j,那么dp数组中dp[0][j..n-1]都为1，即矩阵第一行
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }

        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                //str1 ="A1BC2" str2 ="AB34C" dp[3][4] == dp[4][4] == "ABC"
                //str1 ="A1B2C" str2 ="AB3C4" dp[4][3] == dp[4][4] == "ABC"
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                //当前两个字符相等
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String str1 = "A1BC2D3EFGH45I6JK7LMN";
        String str2 = "12OPQ3RST4U5V6W7XYZ";
        System.out.println(lcse(str1, str2));

    }
}