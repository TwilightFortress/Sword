package test;

import java.util.Arrays;
import java.util.Scanner;

 class test9 {


        int n;
        int s;
        int wait[];
        public test9(int n,int s,int wait[]){
            this.n=n;
            this.s=s;
            this.wait=wait;
        }
        public double waitMin(){
            double total=0D;
            Arrays.sort(wait,1,n);	//排序
            int loop=0;
            if( n/s!= ((double)n)/((double)s) ){
                loop=n/s;
            }else{
                loop=n/s-1;
            }
            for(int i=1;i<=loop*s;i++){
                total+=wait[i];
            }
            return total;
        }
    }
    public class minWait {

        public static void main(String[] args) {
            Scanner reader=new Scanner(System.in);
            int n=reader.nextInt();	//等待人数
            int s=reader.nextInt();	//服务处数
            int wait[]=new int[n+1];
            for(int i=1;i<=n;i++){
                wait[i]=reader.nextInt();
            }
            test9 wa=new test9(n,s,wait);
            System.out.print(wa.waitMin());
        }

    }