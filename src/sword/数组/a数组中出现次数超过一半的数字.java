package sword.数组;

/**
 * 输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 1.若存在超过1半的相同数字，那么数组排序后中间位置元素为此元素。
 * 2.使用快排
 * @author yuyang
 * @create 2019-08-11 10:08
 * 最简单的方式是使用hashmap,但是需要消耗空间，使用下面的方式无序额外的空间复杂度。
 */
public class a数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        //数组通用的边界条件判断
        if(array == null || array.length == 0) return 0;

        int l = 0;
        int r = array.length - 1;
        int m = (l + r)>>1;

        //返回一次快排后中间元素的下标范围
        int[] temp = partition(array, l, r);

        //中间元素不在范围内
        while(m < temp[0] || m > temp[temp.length - 1]){
            if(m < temp[0])
                temp = partition(array, l, temp[0] - 1);
            else if(m > temp[temp.length - 1])
                temp = partition(array, temp[temp.length - 1] + 1, r);
        }
        //在范围内，但有可能没有超过一半长度的元素，所以最后找到中位数需要判断长度是否大于一半
        if((temp[temp.length - 1] - temp[0] + 1)> m)
            return array[m];
        return 0;
    }
    //选择数组最后一个数字，等于这个数字的数放在中间，小于这个数字放在前面， 大于这个数字的放在后面
    public int[] partition(int[] arr, int l, int r){
        //随机选择一个数与最后一个数交换，这样实现了随机选择比较数
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]){
                swap(arr, --more, l);
            }else{
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }
    public void swap(int[] array, int l, int r){
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
