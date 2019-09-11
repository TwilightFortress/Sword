package others.java基础;

/**
 * @author yuyang
 * @create 2019-09-08 17:46
 */
public class 基础2 {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a.show(b) + "-" + a.show(c) + "-" + a.show(d) + b.show(a) + "-" + b.show(c) + "-" + b.show(d));
      //  int[] a = new int[10];
       // a.length
    }
}

class A{
    public String show(D d){return ("AD");}
    public String show(A a){return ("AA");}

}
class  B extends A{
    public String show(B b ){return ("BB");}
    public String show( A a ){return ("BA");}
}
class  C extends B{}
class D extends B{}
