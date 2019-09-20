package others.公司笔试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-15 20:42
 * RRRRRLRLRL
 */
public class 招行1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = fun(str.toCharArray());
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static int[] fun(char[] chars) {
        int[] arr = new int[chars.length];
        Arrays.fill(arr, 1);
        for (int i = 0; i < chars.length; i++) {
            int k = i;
            while (k + 1 < chars.length && chars[k] == 'R' && chars[k + 1] == 'R') {
                k++;
                if (arr[i] > 0) arr[i]--;
            }
            if (k != i && ((k - i) & 1) == 1) {
                arr[k + 1]++;
            } else if ((k != i && ((k - i) & 1) == 0))
                arr[k]++;
            int p = i;
            while (p - 1 >= 0 && chars[p - 1] == 'L' && chars[p] == 'L') {
                p--;
                if (arr[i] > 0) arr[i]--;
            }
            if ( p != i && ((i - p) & 1) == 1) {
                arr[p - 1]++;
            } else if ( p != i && ((i - p) & 1) == 0)
                arr[p]++;
        }
        return arr;
    }
}
