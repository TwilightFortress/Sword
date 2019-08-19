package sword.栈和队列;

import java.util.Stack;

/**
 * @author yuyang
 * @create 2019-08-11 10:07
 */
public class 栈的压入弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null) return false;
        Stack<Integer> stack = new Stack<Integer>();
        int indexPop = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[indexPop]){
                stack.pop();
                indexPop++;
            }
        }
        return stack.empty();
    }
}
