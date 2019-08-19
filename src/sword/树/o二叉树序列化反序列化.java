package sword.树;

/**
 * @author yuyang
 * @create 2019-08-10 10:54
 */
public class o二叉树序列化反序列化 {
    /**
     * 1.中序遍历
     * @param head
     * @return
     */
    public static String Serialize(TreeNode head) {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("$,");
        } else {
            sb.append(head.val + ",");
            sb.append(Serialize(head.left));
            sb.append(Serialize(head.right));
        }
        return sb.toString();
    }

    public static int index = 0;
    public static TreeNode Deserialize(String str) {
        TreeNode p = null;
        if (str == null || str.length() == 0)
            return p;
        int start = index;
        while (str.charAt(index) != ',')
            index++;
        if (!str.substring(start, index).equals("$")) {
            p = new TreeNode(Integer.parseInt(str.substring(start, index)));
            index++; // 这条语句位置别放错了
            p.left = Deserialize(str);
            p.right = Deserialize(str);
        } else {
            index++;
        }
        return p;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(10);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(14);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(16);
        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        String str = Serialize(head);
        System.out.println(str);
        TreeNode node = Deserialize(str);
    }
}
