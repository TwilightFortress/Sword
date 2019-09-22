package test;

import java.util.Scanner;

public class test6 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] box = new int[n];
            int[] key = new int[m];
            for(int i = 0; i < n; i++) {
                box[i] = sc.nextInt();
            }
            for(int i = 0; i < m; i++) {
                key[i] = sc.nextInt();
            }
            int fun1 = fun1(box, key);
            System.out.println(fun1);
        }
        public static int fun1(int[] box, int[] key) {
            int blen = box.length;
            int klen = key.length;
            int bjishu = 0, boushu = 0, kjishu = 0, koushu = 0;
            int res = 0;
            for(int i = 0; i < blen; i++) {
                if(box[i] % 2 == 1)
                    bjishu++;
                else
                    boushu++;
            }
            for(int i = 0; i < klen; i++) {
                if(key[i] % 2 == 1)
                    kjishu++;
                else
                    koushu++;
            }
            res += Math.min(bjishu, koushu);
            res += Math.min(boushu, kjishu);
            return res;
        }
    }
