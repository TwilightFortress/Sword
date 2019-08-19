package others;

import java.util.*;

/**
 * @author yuyang
 * @create 2019-08-10 19:49
 */
public class 求集合交集 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<HashSet<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            int m = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < m; j++){
                set.add(sc.nextInt());
            }
            list.add(set);
        }
        System.out.println(printBest(list));
    }

    private static int printBest(List<HashSet<Integer>> list) {

        int best = 0;
        int num = 0;
        HashSet<Integer> set = new HashSet<>(list.get(list.size() - 1));
        HashSet<Integer> all = new HashSet<>();
        for(int i = 0; i < list.size() - 1; i++){
                all.clear();
                all.addAll(set);
                all.retainAll(list.get(i));
                if(all.size() > num){
                    num = all.size();
                    best = i;
                }
        }
        return best + 1;
    }
}
