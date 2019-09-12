package others.公司笔试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-30 20:21
 */
public class 阿里笔试2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = Integer.parseInt(sc.nextLine());
        System.out.println(getNum(str, count));
    }

    public static String getNum(String str, int count){
        int best = 0;
        int index = 0;

        for (int i = 1; i < str.length() - 1; i++) {
            int sum = 0;
            if(str.charAt(i) == 'b'){
                if(str.charAt(i - 1) == 'g') sum++;
                if(str.charAt(i + 1) == 'g') sum++;
                if(sum > best){
                    best = sum;
                    index = i;
                }
            }
        }
        if(str.charAt(str.length() - 1) == 'b'){
            int sum = 0;
            if(str.charAt(str.length() - 2) == 'g') sum++;
            if(str.charAt(0) == 'g') sum++;
            if(sum > best){
                best = sum;
                index = str.length() - 1;
            }
        }
        String res = index + " ";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'g'){
                int start = (i - 1 + str.length()) % str.length();
                int sum = 0;
                while(str.charAt(start) == 'b'){
                    sum++;
                    start = (start - 1 + str.length()) % str.length();
                }
                list.add(sum);
            }
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i);
            for (int j = 1; j < 4; j++) {
                int n = (i + j) % list.size();
                sum += list.get(n);
            }
            if(sum > max)
                max = sum;
        }
        res += max;
        return res;
    }
}
