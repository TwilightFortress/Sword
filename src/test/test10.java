package test;

import java.util.*;

/**
 * @author yuyang
 * @create 2019-08-25 17:36
 */
public class test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        boolean[] result = new boolean[m + 1];
       // List<Boolean> list = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int n1 = 0;
            Set<Integer> set = new HashSet<>();
            boolean tag = true;
            while (num != 1){
                while(num > 0){
                    n1 = (int)(n1 + Math.pow((num%10), 2));
                    num /= 10;
                }
                num = n1;
                n1 = 0;
                if(set.contains(num)){
                    result[k++] = false;
                    tag = false;
                    break;
                }else{
                    set.add(num);
                }
            }
            if(tag){
                result[k++] = true;
            }
        }
        for (int i = 0; i < result.length - 1; i++) {
            System.out.println(result[i]);
        }
    }
}
