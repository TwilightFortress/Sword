package sword.数组;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * https://www.nowcoder.com/profile/645151/codeBookDetail?submissionId=1516453
 * @author yuyang
 * @create 2019-08-11 10:14
 */
public class i乘积数组 {
    public static int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //计算下三角连乘,先计算每个B[i]的前半段
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            //计算上三角，计算后半段，倒数第二个开始，第一个没有上三角
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] B = multiply(A);
    }
}

