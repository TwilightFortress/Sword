package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author yuyang
 * @create 2019-08-19 20:08
 */
public class 完全平方数组 {
    public static void main(String[] args) {
        int[] arr = {3,6,10};
        ArrayList<String> list = Permutation(arr);
        int num = 0;
        for(int i = 0; i < list.size(); i++){
            String[] ch = list.get(i).substring(1, list.get(i).length() - 1).split(",");
            int[] arr1 = new int[arr.length];
            for (int j = 0; j < ch.length; j++) {
                arr1[j] = Integer.parseInt(ch[j].trim());
            }
            if(check(arr1)){
                num++;
            }
        }
        System.out.println(num);

    }
    private static boolean check(int[] arr1) {
        for(int i = 1; i < arr1.length; i++){
            int tmp = arr1[i - 1] + arr1[i];
            if(!isSquares(tmp)){
                return false;
            }
        }
        return true;
    }
    public static boolean isSquares(int value) {
        if (value < 0) {
            return false;
        }
        double sqrtValue = Math.sqrt(value * 1.0);
        int sqrtSimiValue = (int) sqrtValue;
        if ((sqrtSimiValue * sqrtSimiValue) == value) {
            return true;
        } else {
            return false;
        }
    }
    public static ArrayList<String> Permutation(int[] str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length == 0)
            return list;
        permutationCore(str, 0, list);
        return list;
    }
    private static void permutationCore(int[] chars, int l, ArrayList<String> list) {
        if (l == chars.length - 1) {
            list.add(Arrays.toString(chars));
        } else {
            for (int i = l; i < chars.length; i++) {
                int tmp = chars[l];
                chars[l] = chars[i];
                chars[i] = tmp;
                permutationCore(chars, l + 1, list);
                chars[i] = chars[l];
                chars[l] = tmp;
            }
        }
    }
}
