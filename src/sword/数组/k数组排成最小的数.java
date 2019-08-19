package sword.数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author yuyang
 * @create 2019-08-11 10:10
 */
public class k数组排成最小的数 {
    //使用字符串，大数问题
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null | numbers.length <= 0) return "";
        ArrayList<String> list = new ArrayList<String>();
        for(int number:numbers)
            list.add(String.valueOf(number));
        //自定义sort排序方法，比较规则为两个串拼接，代表的值前最小
        Collections.sort(list,new Comparator<String>(){
            public int compare(String s1, String s2){
                String a = s1 + s2;
                String b = s2 + s1;
                return a.compareTo(b);
            }
        });
        StringBuilder sb = new StringBuilder();
        //排好序后合并这些数字
        for(String str : list)
            sb.append(str);
        return sb.toString();
    }
}
