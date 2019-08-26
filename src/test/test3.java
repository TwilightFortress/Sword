package test;

import java.util.*;

/**
 * @author yuyang
 * @create 2019-08-22 16:40
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(str == null || "".equals(str)){
                System.out.println(0);
                return;
            }
            List<Integer> res = fun(str);
            for (int i = 0; i < res.size() - 1; i++) {
                System.out.print(res.get(i) + " ");
            }
            System.out.println(res.get(res.size() - 1));
        }
    }

    private static List<Integer> fun(String str) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(str != null){
            if(str.length() == 1){
                res.add(i + 1);
                break;
            }
            for (i = 1; i <= str.length() - 2; i++) {
                HashSet<Character> set = new HashSet<>();
                String str1 = str.substring(0, i);
                for (int j = 0; j < str1.length(); j++) {
                    set.add(str1.charAt(j));
                }
                String str2 = str.substring(i, str.length());
                List<Character> list = new ArrayList<>();
                for (int j = 0; j < str2.length(); j++) {
                    list.add(str2.charAt(j));
                }
                set.retainAll(list);
                if(set.size() == 0){
                    res.add(i);
                    str = str.substring(i);
                    break;
                }
            }
            if( i == str.length() - 1){
                res.add(i + 1);
                break;
            }
        }
        return res;
    }
}
