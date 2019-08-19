package sword.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuyang
 * @create 2019-08-10 10:51
 */
public class k之字形打印二叉树 {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode head) {
        if (head == null) return listAll;
        //双端队列：可以左右进出
        Deque<TreeNode> dp = new LinkedList<TreeNode>();
        //true为从左到右打印
        boolean lr = true;
        TreeNode last = head;
        TreeNode nLast = null;
        //头结点加入队列
        dp.offerFirst(head);
        while (!dp.isEmpty()) {
            //从左到右打印
            if (lr) {
                //队头出数据
                head = dp.pollFirst();
                //有左子树，左子树加入队列
                if (head.left != null) {
                    //nLast标识下层的最后一个节点
                    nLast = nLast == null ? head.left : nLast;
                    //从队列尾加入元素，像正常的队列一样
                    dp.offerLast(head.left);
                }
                //有右子树，右子树加入队列
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dp.offerLast(head.right);
                }
            } else {
                //从右到左打印，从队尾出数据
                head = dp.pollLast();
                //先右后左，队头添加元素
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dp.offerFirst(head.right);
                }
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    dp.offerFirst(head.left);
                }
            }
            list.add(head.val);
            //到达每层末尾变换规则
            if (head == last) {
                lr = !lr;
                last = nLast;
                nLast = null;
                listAll.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        return listAll;
    }
}
