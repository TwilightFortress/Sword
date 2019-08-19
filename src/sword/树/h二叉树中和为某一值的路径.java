package sword.树;

import java.util.ArrayList;

/**
 * 1.先序遍历
 * 2.当前节点添加到路径中，目标值递减
 * 3.判断目标值是否为0，当前节点是否为叶子节点
 * 4.当前节点判断完从路径中移除
 *
 * @author yuyang
 * @create 2019-08-10 10:47
 */
public class h二叉树中和为某一值的路径 {
    //存放所有路径
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    //存放当前路径
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        //走过的节点添加到当前路径中
        list.add(root.val);
        //目标值减去当前值
        target -= root.val;
        //当前节点如果满足条件，则为一条路径，添加到所有路径集合中
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        //递归判断，当前节点的左子树是否满足条件，右子树是否满足条件，
        FindPath(root.left, target);
        FindPath(root.right, target);
        //当前节点判断完需要从当前路径中移除，接着用来判断下一条路径
        list.remove(list.size()-1);
        return listAll;
    }
}
