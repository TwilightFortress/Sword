package others.公司笔试题;

import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-10 19:59
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
public class 小度的部队 {
    static int k = 0;
    private static void getCount(TreeNode head) {
        if(head == null){
            return;
        }
        if(head.left == null && head.right == null){
            k++;
        }
        getCount(head.left);
        getCount(head.right);
    }
    private static TreeNode createTree(int n, int m) {
        TreeNode head = new TreeNode(n);
        if(n > m + 1){
            int[] arr = fun(n, m);
            if(arr[0] ==arr[1] - m){
      //          System.out.println(arr[0] + " " + arr[1]);
                head.left = createTree(arr[0], m);
                head.right = createTree(arr[1], m);
            }
        }
        return head;
    }
    private static int[] fun(int n, int m) {
            //10 6 4
        int i = 1;
        while(i < n && i + m < n - i){
            i++;
        }
        return new int[]{i, n - i};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(n < m) {
            System.out.println(0);
            return;
        }
        TreeNode head = createTree(n, m);
        getCount(head);
        System.out.println(k);
        k = 0;
    }
}
