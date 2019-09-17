package others.公司笔试题;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-16 21:10
 * ac 100%
 */
public class 五八_笔试题2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(",");
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < tmp.length; i++) {
            int num = Integer.parseInt(tmp[i]);
            if(!map.containsKey(num)) map.put(Integer.parseInt(tmp[i]), 1);
            else map.put(num, map.get(num) + 1);
        }
        int sum = 0;
        for (Integer i : map.keySet()) {
            int count = map.get(i);
            int div = count / (i + 1);
            int mod = count % (i + 1);
            sum += div * (i + 1);
            if(mod != 0) sum += (i + 1);
        }
        System.out.println(sum);
    }
}
