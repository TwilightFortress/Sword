package test;


import java.util.*;

/**
 * @author yuyang
 * @create 2019-08-24 20:05
 */
public class test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ArrStr = str.split(" ");
        int n = Integer.parseInt(ArrStr[0]);
        int m = Integer.parseInt(ArrStr[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                int k = sc.nextInt();
                if (!map.containsKey(k)) {
                    map.put(k, 1);
                } else {
                    map.put(k, map.get(k) + 1);
                }
            }
        }
        int numM = 0;
        int numV = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Integer in : map.keySet()) {
            if (map.get(in) > 1 && in <= n) {
                numM++;
                list1.add(in);
            }
            if (map.get(in) > 1 && in > n) {
                numV++;
                list2.add(in);
            }
        }
        if (numM == numV) {
            System.out.println(numM);
            for (Integer integer : list1) {
                System.out.print(integer + " ");
            }
        } else if (numM > numV) {
                System.out.println(numM);
                for (Integer integer : list1) {
                    System.out.print(integer + " ");
                }
            }else{
            System.out.println(numV);
            for (Integer integer : list2) {
                System.out.print(integer + " ");
            }

        }
    }
}
