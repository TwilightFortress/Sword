package sword.树;

import java.util.Stack;

import static sword.树.aa创建树.CreateTree;

/**
 * 先、中、后的递归+非递归
 * @author yuyang
 * @create 2019-08-10 10:56
 */
public class a二叉树的遍历 {

    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //树的高度
    public static int getHeight(TreeNode head, int h) {
        if (head == null) return h;
        return Math.max(getHeight(head.left, h + 1), getHeight(head.right, h + 1));
    }

    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val + " ");
    }

    //先序：栈
    public static void preOrderUnRecur(TreeNode head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            //第一个节点入栈
            stack.add(head);
            while (!stack.isEmpty()) {
                //头节点弹出打印
                head = stack.pop();
                System.out.print(head.val + " ");
                //如果头节点又子数不为空入栈，左子树不为空入栈，这里先入右子树
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //中序：栈
    public static void inOrderUnRecur(TreeNode head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty() || head != null) {
                //压入所有左边界
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                    //
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //后序：先序的启发改良 :按照先序的规则压入：中 左 右  反序就是 左右中
    public static void posOrderUnRecur1(TreeNode head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
        System.out.println();
    }

    //后序2
    public static void posOrderUnRecur2(TreeNode h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(h);
            TreeNode c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().val + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        TreeNode head = CreateTree();
        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);

        //	System.out.println(head.g);
    }

}

