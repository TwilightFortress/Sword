package others.公司笔试题;

        import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-21 16:05
 */
public class 网易1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int tmp = sc.nextInt();
            System.out.println(getMinN(tmp));
        }
    }

    private static String getMinN(int tmp) {
        String res = "";
        while(tmp > 9){
            res = "9" + res;
            tmp -= 9;
        }
        if(tmp == 0) return res;
        else return String.valueOf(tmp) + res;
    }
}
