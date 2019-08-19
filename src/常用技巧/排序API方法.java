package 常用技巧;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author yuyang
 * @create 2019-08-18 13:38
 */
public class 排序API方法 {
    public static void main(String[] args) {
        //int类型最大正整数为0x7FFFFFFF，最小负整数为0x80000000。

        //保留小数位数
        Double b = 0.235445435;
        System.out.println(String.format("%.6f", b));

        //数组排序-升序
        int[] arr = {1,8,4,6,9,4,23,5};
        Arrays.sort(arr);

        //集合排序，排序对象为基本数据类型
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(3);
        //升序
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        //降序
        Collections.sort(list,Collections.reverseOrder());
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        //排序对象不是基本数据类型

    }
}
