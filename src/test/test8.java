package test;

import javax.crypto.spec.DESedeKeySpec;

public class test8 {
    public static void main(String[] args) {
        Demo de = new Demo();
        test8 tf = new test8();
        String result = tf.fun1(de);
        System.out.println(result);
    }

    private String fun1(Demo de){
        try{
            de.str += "1";
            return fun2(de);
        }finally {
            de.str += "2";
            return de.str;
        }
    }

    private String fun2(Demo de){
        try{
            de.str +="3";
            return de.str;
        }finally {
            de.str += "4";
        }
    }
}
class Demo{
    String str = "";
}