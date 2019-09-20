package sword.树;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-12 15:45
 */
/*
输入
dgbaechf
gbdehfca
输出
adbgcefh
 */
public class 二叉树中序后序得到先序 {
    public static String pre = "";
    public static void getPre(String in, String pos){
        boolean b = check(in, pos);
        if(b == false) return;
        if(in.length() == 0) return;
        if(in.length() == 1){
            pre += in;
            return;
        }
        char node = pos.charAt(pos.length() - 1);
        int i1 = in.indexOf(node);
        String s1 = in.substring(0, i1);
        String s2 = in.substring(i1 + 1);
        pre += String.valueOf(node);
        getPre(s1, pos.substring(0, s1.length()));
        getPre(s2, pos.substring(s1.length(), pos.length() - 1));
        return;
    }
    public static boolean check(String in, String pos){
        boolean b = true;
        if(in.length() != pos.length()){
            b = false;
        }
        if(in.length() == pos.length()){
            for (int i = 0; i < in.length(); i++) {
                if(pos.indexOf(in.charAt(i)) == -1)
                    b = false;
            }
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine().trim();
        String pos = sc.nextLine().trim();
        getPre(in, pos);
        System.out.println(pre);
        pre = "";
    }
}
