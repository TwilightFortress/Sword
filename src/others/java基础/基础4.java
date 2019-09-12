package others.java基础;

/**
 * @author yuyang
 * @create 2019-09-11 15:34
 */
public class 基础4 {
    public static void main(String[] args) {
        int a[] = new int[2];
        try{
            System.out.println(a[3]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("###");
        }finally {
            a[0] = 6;
            System.out.println(a[0]);
            System.out.println("****");
        }

    }
}

