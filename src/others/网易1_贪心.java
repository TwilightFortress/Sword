package others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-14 19:13
 *
 */
public class 网易1_贪心 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(",");
        int len1 = nums.length;
        int[] arr = new int[len1];
        int index = 0;
        for (String num : nums) {
            arr[index++] = Integer.parseInt(num);
        }

        String[] arrs = sc.nextLine().split(",");
        int len2 = arrs.length;
        int[] arr2 = new int[len2];
        int index2 = 0;
        for (String num : arrs) {
            arr2[index2++] = Integer.parseInt(num);
        }
        System.out.println(findContentChildren(arr, arr2));

    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
