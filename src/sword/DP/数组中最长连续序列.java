package sword.DP;

import java.util.HashMap;

/**
 * 给定无序数组，返回最长连续序列长度
 * arr=[100,4,200,1,3,2] 1234
 *hashMap(时间,空间都O(n))
 * @author yuyang
 * @create 2019-08-14 16:09
 */
public class 数组中最长连续序列 {

    public static int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max, merge(map, arr[i], arr[i] + 1));
                }
            }
        }
        return max;
    }

    public static int merge(HashMap<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));

    }

}
