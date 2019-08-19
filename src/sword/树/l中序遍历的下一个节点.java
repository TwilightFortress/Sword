package sword.树;

/**
 * 树结构中有指向父节点的指针
 * @author yuyang
 * @create 2019-08-10 10:49
 */
public class l中序遍历的下一个节点 {
    public TreeLinkNode GetNext(TreeLinkNode head)
    {
        TreeLinkNode p;
        //有右子树，右子树的最左节点
        if(head.right!=null) {
            p=head.right;
            while(p.left!=null) {
                p=p.left;
            }
            return p;
        }
        //没有右子树，从父节点向上找，找到为左子树的父节点。
        p=head;
        while(p.pre!=null) {
            //当前节点是其父节点的左子树，返回其父节点
            if(p.pre.left==p)
                return p.pre;
            p=p.pre;
        }
        return null;
    }
}