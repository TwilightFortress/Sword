package sword.数组;

import java.util.ArrayList;

/**
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author yuyang
 * @create 2019-08-11 10:08
 */
public class b最小的k个数 {
    public static ArrayList<Integer> MinNumber(int [] arr, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        while(arr==null || k<=0 || k>arr.length)
            return nums;

        int l=0;
        int r=arr.length-1;
        int index=partition(arr,l,r);

        while(index!=k-1){
            if(index<k-1){
                l=index+1;
                index=partition(arr,l,r);
            }else{
                r=index-1;
                index=partition(arr,l,r);
            }
        }
        for(int i=0;i<k;i++){
            nums.add(arr[i]);
        }
        return nums;
    }

    //快排 ：找到下标为k的值，分成前面小于k,后面大于k
    public static int partition(int[] arr, int l, int r) {
        //数组最后一个数作为比较值
        int p = arr[r];

        //小于区域边界
        int less = l - 1;

        for(int i = l; i <= r; i++){
            if(arr[i] <= p){
                swap(arr, ++less, i);
            }
        }
        return less;
    }

    private static void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int arr[] = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = MinNumber(arr,4);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
