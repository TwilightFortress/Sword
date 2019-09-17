package others.公司笔试题;
import java.io.IOException;
import java.util.*;
/*
AC 80%
 */
public class 五八_二叉树中节点均值最大的一层 {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    private Node createBinaryTreeByArray(Integer[] array,int index)
    {
        Node tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new Node(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

    public int levelOrder(Node root){
        int max = 0;
        int level = 0;
        int k1 = 0;
        //请您完成此方法
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node last = root;
        Node nlast = null;
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            list.add(root.val);
            if(root.left != null){
                queue.add(root.left);
                nlast = root.left;
            }
            if(root.right != null){
                queue.add(root.right);
                nlast = root.right;
            }
            if(root == last){
                int n = 0;
                for (int i = 0; i < list.size(); i++) {
                    n += list.get(i);
                }
                k1++;
                if(n/list.size() > max){
                    level = k1;
                    max = n/list.size();
                }
                list.clear();
                last = nlast;
            }
        }
        return level;
    }


    public  Node createTree(int[] array){
        List<Node> nodeList=new LinkedList<Node>();

        for(int nodeIndex=0;nodeIndex<array.length;nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        for(int parentIndex=0;parentIndex<=array.length/2-1;parentIndex++){
            nodeList.get(parentIndex).left =nodeList.get(parentIndex*2+1);
            //防止是非完全二叉树
            if((parentIndex*2+2)<array.length) {
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }
        return nodeList.get(0);
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int [] array = new int [n];
        Integer [] array = new Integer[n];
        for(int i = 0;i < n;i++){
            String value =scanner.next();
            if(value.equals( "null" )){
                array[i]=null;
            }else{
                array[i] = Integer.valueOf( value );
            }

        }
        五八_二叉树中节点均值最大的一层 solution = new 五八_二叉树中节点均值最大的一层();
        Node root =solution.createBinaryTreeByArray(array,0);
        int level = solution.levelOrder( root );
        System.out.println(level);

    }
}