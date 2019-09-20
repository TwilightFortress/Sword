package sword.字符串;

import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 * @author yuyang
 * @create 2019-08-11 10:10
 */
public class g第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        if(str==null)
            return -1;
        //字符为2个字节，一个字节4位，2个字节为8位。字符8位，ASCII码范围2的8次方 256
        int[] repetitions = new int[256];
        //初始化
        for(int i=0;i<256;i++)
            repetitions[i]=0;
        //遍历字符串，将字符转化为int类型，存入相应的数组下标，数组的值为出现的次数
        for(int i=0;i<str.length();i++) {
            int loc=(int) str.charAt(i);
            repetitions[loc]+=1;
        }
        //得到第一个值为1的元素
        //从字符串第一个字符开始取，判断在数组中相应下标位置中的值是否为1
        for(int i=0;i<str.length();i++) {
            int loc=(int) str.charAt(i);
            if(repetitions[loc]==1)
                return i;
        }
        return -1;
    }

    //hash表的方式存储
    public static int fun(String str){
        if(str == null)
            return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for (int j = 0; j < str.length(); j++) {
            if(map.get(str.charAt(j)) == 1){
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "hellohikvision";
        System.out.println(fun(str));
    }
}
