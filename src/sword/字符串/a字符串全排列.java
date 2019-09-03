package sword.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串abc,打印全部的排列。
 * @author yuyang
 * @create 2019-08-08 11:03
 */
public class a字符串全排列 {
    /**
     *
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation(String str) {
        //存储最后的全排列
        ArrayList<String> list = new ArrayList<String>();
        //边界
        if (str == null || str.length() == 0)
            return list;
        //字符串处理通常需要将字符串转化为字符数组
        permutationCore(str.toCharArray(), 0, list);
       // Collections.sort(list);  //将list中的字符串排序
        return list;
    }

    /**
     * 1.遍历数组，第一个字符串，和后面的其他字符串交换，交换完，要回溯回来，其他的交换也是在初始条件上进行的。
     * 2.每一次交换后，递归进行数组其他的字符的交换。
     * @param chars
     * @param l
     * @param list
     */
    private static void permutationCore(char[] chars, int l, ArrayList<String> list) {
        if (l == chars.length - 1) {
          //  if (!list.contains(String.valueOf(strArray)))  //判断是否有重复字符串
                list.add(String.valueOf(chars));
        } else {
            for (int i = l; i < chars.length; i++) {
                //和后面每一个交换
                char tmp = chars[l];
                chars[l] = chars[i];
                chars[i] = tmp;
                //递归其他的
                permutationCore(chars, l + 1, list);
                //交换完，恢复原样
                chars[i] = chars[l];
                chars[l] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = Permutation("abc");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
/*
  select s.sid, s.sname for s where sid in(select sid for sc where cid = (select cid form c where cname = "计算机"));

  select cname form C where cid in(select cid form sc where sid = (select sid for s where sname = "周"));
 */