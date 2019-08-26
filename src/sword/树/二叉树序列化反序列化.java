package sword.树;

import static sword.树.aa创建树.CreateBFS;

/**
 * @author yuyang
 * @create 2019-08-10 10:54
 */
public class 二叉树序列化反序列化 {
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
        TreeNode head = CreateBFS();
        String str = Serialize(head);
        System.out.println(str);
        TreeNode node = Deserialize(str);
    }
}
