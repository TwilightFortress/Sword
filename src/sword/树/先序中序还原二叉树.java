package sword.树;

/**
 * 1.遍历中序，从其中找到先序第一个。
 * 2.中序被分为两部分，前面部分为左子树，后面为右子树
 * @author yuyang
 * @create 2019-08-10 10:44
 */
public class 先序中序还原二叉树 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0,
                in.length - 1);
        return root;
    }

    // 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
                                                  int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        //前序第一个为头结点
        TreeNode root = new TreeNode(pre[startPre]);
        //遍历中序
        for (int i = startIn; i <= endIn; i++)
            //中序数组被前序确定的节点分开，前面为左子树，后面为右子树
            if (in[i] == pre[startPre]) {
                // startPre + 1:前序下一个开始
                //startpre + i -startIn:前序数组进入递归下标结尾，i - startIn是中序走了几个 + startPre为前序数组结束下标
                //i-1:中序找的次数就是中序的个数
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre
                        + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre
                        + 1, endPre, in, i + 1, endIn);
                //找到就不用再遍历了
                break;
            }

        return root;
    }
}
