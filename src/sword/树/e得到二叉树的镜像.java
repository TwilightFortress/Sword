package sword.树;

import static sword.树.a二叉树的遍历.preOrderRecur;
import static sword.树.aa创建树.CreateBFS;

/**
 * @author yuyang
 * @create 2019-08-10 10:45
 */
public class e得到二叉树的镜像 {
    static TreeNode tmp;
    public static void Mirror(TreeNode head){
        if(head != null){
            //交换左右子树
            if(head.left != null || head.right != null){
                tmp = head.left;
                head.left = head.right;
                head.right = tmp;
            }
            Mirror(head.left);
            Mirror(head.right);
        }
    }

    public static void main(String[] args) {
        TreeNode head = CreateBFS();
        preOrderRecur(head);
        System.out.println("\n" + "----------");
        Mirror(head);
        preOrderRecur(head);
    }
}
