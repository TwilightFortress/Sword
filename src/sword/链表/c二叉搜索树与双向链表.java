package sword.链表;


import sword.树.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 1.二叉搜索树中序遍历是有序的
 * 2.中序遍历的第一个节点就是链表头结点
 * @author yuyang
 * @create 2019-08-08 15:22
 */
public class c二叉搜索树与双向链表 {
    TreeNode head = null;
    //真正的头结点，遍历树过程中，找到后，标记上
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        //找到整个树中最左边的节点
        ConvertSub(pRootOfTree.left);
        //最左边第一个为空的节点是链表的头结点
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            //head为当前节点的前一个节点，连接双向链表的前后指针
            //head的next等于当前节点
            head.right = pRootOfTree;
            //当前节点的pre为head
            pRootOfTree.left = head;
            //head指向当前节点，当前节点向后移动
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
