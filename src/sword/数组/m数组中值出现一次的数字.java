package sword.数组;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次
 * @author yuyang
 * @create 2019-08-11 10:12
 */

/**
 * 1.两个相同的数字异或为0
 * // 1,1,2,2,3,3,4,5
 * 1,1,2,2,4
 * 3,3,5
 */
public class m数组中值出现一次的数字 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 1) return;
        int syb = 0;

        for(int i = 0; i < array.length; i++){
            syb ^= array[i];
        }
        //得到异或后不为0的位数 1,1,2,2,3
        int indexOf1 = 0;
        while(((syb&1)==0) && (indexOf1<=4*8)){
            syb=syb>>1;  //只有n>>1不完整，要n=n>>1
            indexOf1++;
        }
        num1[0] = 0;
        num2[0] = 0;
        for(int i=0;i<array.length;i++){
            //所有这一位为1的
            if(((array[i]>>indexOf1)&1)==1)
                num1[0]^=array[i];
            else
                num2[0]^=array[i]; //这一位不为1的
        }
    }
}
