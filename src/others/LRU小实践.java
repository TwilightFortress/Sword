package others;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-14 19:00
 */
/*
1,2,1,3,2,1,4,3,4
2
-1，-1，1，-1，-1，-1，-1，-1，4
 */
class LRU<K, V> extends LinkedHashMap<K, V> {
    private int maxEntries;
    public LRU(int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }
}
public class LRU小实践 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int n = Integer.parseInt(sc.nextLine());
        int[] res = new int[arr.length];
        LRU lru = new LRU(n);
        for (int i = 0; i < arr.length; i++) {
            if(lru.containsKey(arr[i])){
                res[i] = arr[i];
                lru.get(arr[i]);
            }else{
                res[i] = -1;
                lru.put(arr[i],"");
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + "，");
        }
    }
}
