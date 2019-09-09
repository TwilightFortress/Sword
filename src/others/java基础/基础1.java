package others.java基础;

/**
 * @author yuyang
 * @create 2019-09-08 17:44
 */
public class 基础1 {
    static 基础1 t = new 基础1();
    static int a;
    static int b = 1;
    基础1(){
        a++;
        b++;
    }
    static 基础1 get(){
        return t;
    }

    public static void main(String[] args) {
        基础1 t = 基础1.get();
        System.out.println(a + " " + b);
    }
}
