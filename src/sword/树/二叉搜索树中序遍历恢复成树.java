package sword.树;

import static sword.树.a二叉树的遍历.inOrderRecur;

/**
 * @author yuyang
 * @create 2019-08-30 16:13
 */
public class 二叉搜索树中序遍历恢复成树 {
    public static void main(String[] args) {

        int[] arr = {10, 6, 4, 8, 14, 12, 16};
        TreeNode node = fun(arr);
        inOrderRecur(node);
    }

    public static TreeNode fun(int[] arr){
        if(arr.length <= 0) return null;
        return fun(arr, 0, arr.length - 1);
    }

    private static TreeNode fun(int[] arr, int i, int length) {
        if(i != length){
            TreeNode head = new TreeNode(arr[i]);
            int j = i;
            for (; j < length; j++) {
                if(arr[j] > arr[i]) break;
            }
            head.left = fun(arr, i + 1, j - 1);
            head.right = fun(arr, j, length);
            return head;
        }
        return new TreeNode(arr[i]);
    }
}
