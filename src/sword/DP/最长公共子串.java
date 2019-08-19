package sword.DP;

/**
 * str1 = ABC1234567DEFG
 * str2 = HIJKL1234567MNOP
 * str = 1234567
 * @author yuyang
 * @create 2019-08-14 15:41
 */
public class 最长公共子串 {

    public static String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int end = 0;
        int max = 0;
        //找到dp数组中最大的值
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    /**
     * 生成dp[i][j]:把str1[i]与str2[j]当做公共子串最后一个字符，公共子串最长有多长。
     * 注：这就说明str1[i]如果不等于str2[j],那么dp[i][j] = 0。
     * @param str1
     * @param str2
     * @return
     */
    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        //矩阵第一列，str1[i] == str2[0],即为1，不相等即为0
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        //第一行同第一列
        for (int j = 1; j < str2.length; j++) {
            if (str1[0] == str2[j]) {
                dp[0][j] = 1;
            }
        }
        //不相等为0，不用处理，相等为：dp[i][j] = dp[i - 1][j - 1] + 1;
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    public static String lcst2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = 0; // 斜线开始位置的行
        int col = chs2.length - 1; // 斜线开始位置的列
        int max = 0; // 记录最大长度
        int end = 0; // 最大长度更新时，记录子串的结尾位置
        while (row < chs1.length) {
            int i = row;
            int j = col;
            int len = 0;
            // 从(i,j)开始向右下方遍历
            while (i < chs1.length && j < chs2.length) {
                if (chs1[i] != chs2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                // 记录最大值，以及结束字符的位置
                if (len > max) {
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
            if (col > 0) { // 斜线开始位置的列先向左移动
                col--;
            } else { // 列移动到最左之后，行向下移动
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        String str1 = "ABC1234567DEFG";
        String str2 = "HIJKL1234567MNOP";
        System.out.println(lcst1(str1, str2));
        System.out.println(lcst2(str1, str2));

    }

}