package others;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuyang
 * @create 2019-09-09 15:55
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int maxEntries;

    public LRUCache(int maxEntries) {
                                                    //true表示基于访问排序，false表示按照插入顺序排序
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    //返回true时移除linkedHashMap中最老的值，就是链表中最前面的值。
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }

    public static void main(String[] args) {
        LRUCache<String,Object> cache = new LRUCache<>(3);
        cache.put("a","abstract");
        cache.put("b","basic");
        cache.put("c","call");
        cache.get("a");
        cache.put("d","滴滴滴");
        System.out.println(cache); // 输出为：{c=call, a=abstract, d=滴滴滴}
    }
}
