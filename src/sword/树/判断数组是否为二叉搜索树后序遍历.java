package sword.树;

/**
 * 前提：树为二叉搜索树
 * @author yuyang
 * @create 2019-08-10 10:46
 */
public class 判断数组是否为二叉搜索树后序遍历 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        //边界：头结点为空返回false
        if (sequence.length == 0) return false;
        //递归判断，参数需要数组的开始，结束下标，都这个套路
        return IsTreeBST(sequence, 0, sequence.length - 1);
    }

    public boolean IsTreeBST(int[] sequence, int start, int end) {
        if (end <= start) return true;
        int i = start;
        //找到第一个大于头结点的数，这个数之前是左子树，之后是右子树
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) break;
        }
        //之后的数如果有小于最后一个数的，则不满足二叉搜索树
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) return false;
        }
        //递归判断左右子树，是否都满足二叉搜索树的条件
        return IsTreeBST(sequence, start, i - 1) && IsTreeBST(sequence, i, end - 1);
    }
}
