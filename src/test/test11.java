package test;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-25 18:00
 */
public class test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        String[] res = new String[str1.length + str2.length];
        int k = 1, k1 = 0, k2 = 0;
        for (int i = 0; i < str1.length; i++, k++) {
            res[k1++] = str1[i];
            if(k % 4 == 0){
                if(k2 < str2.length){
                    res[k1++] = str2[k2++];
                }
            }
        }
        while(k2 < str2.length){
            res[k1++] = str2[k2++];
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
