package others;

import java.util.*;

/**
 * @author yuyang
 * @create 2019-09-15 19:27
 */
public class LUFcache extends HashMap {
    public int maxSize;
    //记录变量的访问次数
    Map<Integer, Help> map = new HashMap<>();
    public LUFcache(int num) {
        this.maxSize = num;
    }
    class Help implements Comparable<Help> {
        Integer key;
        Integer count;
        Long curtime;
        public Help(Integer key, Integer hitCount, Long curtime) {
            this.key = key;
            this.count = hitCount;
            this.curtime = curtime;
        }
        @Override
        public int compareTo(Help h) {
            int num = count.compareTo(h.count);
            return num != 0 ? num : curtime.compareTo(h.curtime);
        }
    }
    public Integer get(Object key) {
        Integer in = (Integer) super.get(key);
        if (in != null) {
            Help help = map.get(key);
            help.count++;
            help.curtime = System.currentTimeMillis();
        }else{
            return -1;
        }
        return in;
    }
    public Integer set(Integer key, Integer value) {
        while (map.size() >= maxSize) {
            Integer in = mincount();
            map.remove(in);
            this.remove(in);
        }
        Integer val = (Integer) super.put(key, value);
        map.put(key, new Help(key, 1, System.currentTimeMillis()));
        return val;
    }
    public Integer mincount() {
        Help h = Collections.min(map.values());
        return h.key;
    }
    public static void main(String[] args) {
        LUFcache cache = new LUFcache(3);
        List<Integer> list = new ArrayList<>();
        cache.set(2, 2);
        cache.set(1, 1);
        list.add(cache.get(2));
        list.add(cache.get(1));
        list.add(cache.get(2));
        cache.set(3, 3);
        cache.set(4, 4);
        list.add(cache.get(3));
        list.add(cache.get(2));
        list.add(cache.get(1));
        list.add(cache.get(4));
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
