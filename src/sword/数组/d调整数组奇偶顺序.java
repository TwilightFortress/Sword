package sword.数组;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author yuyang
 * @create 2019-08-11 10:05
 */
public class d调整数组奇偶顺序 {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0) return;
        for(int i = 1; i < array.length; i++){
            //当前数为奇数
            if((array[i]&1) != 0){
                //类似于插入排序，选择当前数前面的数，偶数的话就一直先前交换
                for(int j = i - 1; j >= 0 && (array[j]&1) == 0; j--){
                    swap(array, j, j + 1);
                }
            }
        }
    }
    public void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
