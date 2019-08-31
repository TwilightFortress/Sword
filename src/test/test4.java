package test;

/**
 * @author yuyang
 * @create 2019-08-30 19:52
 */
import java.util.Arrays;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }


    private static int getMinimumTimeCost(int n, int[][] area) {

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int j = 0; j < n; j++){
            for(int i = 1; i < n; i = i + 2) {
                arr[j] += area[i][j];
            }
        }
        return getmin(arr);
    }

    private static int getmin(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}