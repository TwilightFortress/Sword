package 常用技巧;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuyang
 * @create 2019-08-18 13:18
 */
public class 字符串转化成数组 {
    public static void main(String[] args) {

        String str = "1s23v4a54";
        char[] chars = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < chars.length; i++){
            //合法字符
            if(chars[i] > '0' && chars[i] < '9'){
                //字符转化成数字
                list.add((int)(chars[i] - '0'));
            }
        }
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        Arrays.sort(arr);

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("-----------");

        List list1 = Arrays.asList(arr);
        for (Object o : list1) {
            System.out.print(o + " ");
        }

    }
}
