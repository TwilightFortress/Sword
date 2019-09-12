package others.java基础;

/**
 * @author yuyang
 * @create 2019-09-11 15:31
 */
public class 基础3 {
    public static void main(String[] args) {
        String s1 = "qp" + "zm";
        String s2 = "qpzm";
        String s3 = new String("qpzm");

        if(s1 == s2){
            System.out.println("s1 == s2 return true");
        }else{
            System.out.println("s1 == s2 return false");
        }

        if(s1.equals(s3)){
            System.out.println("s1.eq(s3) true");
        }else{
            System.out.println("s1.eq(s3) false");
        }

    }
}
