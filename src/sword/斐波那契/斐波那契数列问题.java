package sword.斐波那契;

/**
 * @author yuyang
 * @create 2019-08-11 10:02
 */
public class 斐波那契数列问题 {
    public int Fibonacci(int n) {
        int preNum=1;
        int prePreNum=0;
        int result=0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(int i=2;i<=n;i++){
            //f(n) = f(n - 1) + f(n - 2); f(0) = 0; f(1) = 1;
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;

    }
}