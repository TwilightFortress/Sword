package test;

import java.io.IOException;

public class test3 {
    public int methodA() throws IOException{
        System.out.println("m1");
        throw new IOException();
    }
    public static void main(String[] args) {
        test3 t = new test3();
        try{
            t.methodA();
        }catch (IOException e){
            System.out.println("IO");
            throw new IndexOutOfBoundsException();
        }catch(Exception e){
            System.out.println("C");
        }finally {
            System.out.println("f");
        }
    }
}
