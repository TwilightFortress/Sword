package sword.DP;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-20 19:30
 */
public class 背包问题 {
    public static void main(String[] args) {

//        int[] w = {2,2,6,5,4};
//        int[] v = {6,3,5,4,6};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for(int i = 0; i < n; i++){
            w[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            v[j] = sc.nextInt();
        }
        System.out.println(fun(m, n, w, v));
    }
        public static int fun(int m,int n,int w[],int v[]){
            //c[i][m] 表示前i件物品恰好放入重量为m的背包时的最大价值
            int c[][] = new int[n+1][m+1];

            for(int i=0;i<n+1;i++){
                c[i][0] = 0;
            }
            for(int j=0;j<m+1;j++){
                c[0][j] = 0;
            }
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(w[i-1] <= j){
                        if(c[i-1][j] <c[i-1][j-w[i-1]]+v[i-1]){
                            c[i][j] = c[i-1][j-w[i-1]]+v[i-1];
                        }else{
                            c[i][j] = c[i-1][j];
                        }
                    }else{
                        c[i][j] = c[i-1][j];
                    }
                }
            }
            return c[n][m];
        }
}
