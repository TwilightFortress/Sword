package test;

/**
 * @author yuyang
 * @create 2019-08-24 16:02
 */
public class test4 {

    public static int fun1(int i){
        return i <= 5 ? i :fun1(1 - i)*fun1(i - 3);
    }

    public  static  int fun2(int i ){
        return ((i >> 8) & 0x6597) & (((i << 8) & 0x6597) >> 8);
    }

    public static void main(String[] args) {
        int n = fun2(fun1(101)) % 4;
        System.out.println(n);
    }
}
