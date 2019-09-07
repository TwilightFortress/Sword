package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test7 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }
            System.out.println(getMax(w));
        }

        private static int getMax(int[] w) {
            int result = 1;
            for (int i = 0; i < w.length; i++) {
                int tmpRes = 1;
                List<Integer> tmp = new LinkedList<>();
                for (int j = i; j < w.length; j++) {
                    tmp.add(w[j]);
                    tmpRes = min(tmp) * sum(tmp);
                }
                if (tmpRes > result) {
                    result = tmpRes;
                }
            }
            return result;
        }

        private static int sum(List<Integer> tmp) {
            int sum = 0;
            for (Integer obj : tmp) {
                sum += obj;
            }
            return sum;
        }

        private static int min(List<Integer> tmp) {
            int min = tmp.get(0);
            for (Integer obj : tmp) {
                if (obj < min) {
                    min = obj;
                }
            }
            return min;
        }
    }


