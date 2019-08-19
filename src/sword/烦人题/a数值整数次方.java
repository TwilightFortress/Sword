package sword.烦人题;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author yuyang
 * @create 2019-08-11 10:04
 */
public class a数值整数次方 {
    public double Power(double base, int exponent) {
        //边界
        if(exponent==0 && base != 0)
            return 1;
        if(exponent==1)
            return base;
        if(base == 0 && exponent <= 0){
            throw new RuntimeException();
        }
        if(base ==0 && exponent>0){
            return 0;
        }

        //负数用正数算，最后取倒数
        int n= exponent;
        if(exponent<0){
            n = -exponent;
        }

        double result=Power(base,n>>1);
        result*=result;
        if((n&1)==1)
            result*=base;
        //负数次幂，
        if(exponent<0)
            result=1/result;
        return result;
    }
}
