package sword.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n个字符，选择m个的全排列
 * 1.将字符转化成list:arrays.asList(data);
 *
 * @author yuyang
 * @create 2019-08-08 11:15
 */
public class  b字符串全排列进阶 {
    public static void main(String[] args) throws Throwable {
        String[] data = {"1", "2", "3", "4", "5"};
        int num = 3;
        List<List<String>> result = parade(Arrays.asList(data), num);
        for (List<String> l : result) {
            System.out.println(l);
        }
        System.out.printf("total:%s\n", result.size());
    }
    public static List<List<String>> parade(List<String> data, int num) {

        List<List<String>> result = new ArrayList<List<String>>();
        if (num == 1) { //此时data中只有三个元素
            for (String s : data) {
                List<String> l = new ArrayList<String>();
                l.add(s);
                result.add(l); //每个元素分别保存到结果集
            }
            return result; //并返回结果集
        }

        for (int i = 0; i < data.size(); i++) {
            List<String> list = new ArrayList<String>(data);
            list.remove(i);
            //选定一个，返回从从剩下的4个里面选2个的所有可能放到sub中
            List<List<String>> sub = parade(list, num - 1);
            for (List<String> l : sub) {
                //将选定的那一个放到每个sub中
                l.add(0, data.get(i));
                result.add(l);
            }
        }

        return result; //最后返回结果集
    }
}