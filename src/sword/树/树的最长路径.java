package sword.树;

/**
 * @author yuyang
 * @create 2019-09-15 18:58
 */

public class 树的最长路径 {
    public static TreeNode create(){
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        return node;
    }
    public static int MaxTrace(TreeNode head){
        if(head == null) return 0;
        int l = TreeDepth(head.left);
        int r = TreeDepth(head.right);
        if(l == 0 && r == 0){
            return 0;
        }
        return l + r;
    }
    public static int TreeDepth(TreeNode head){
        if(head == null) return 0;
        return Math.max(TreeDepth(head.left), TreeDepth(head.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = create();
        System.out.println(MaxTrace(node));
        String[]  a = "132.45.576.56".split("\\.");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
