package sword.栈和队列;

import java.util.Stack;

/**
 * @author yuyang
 * @create 2019-08-11 10:06
 */
public class 包含min函数的栈 {
    static Stack stack1 = new Stack();
    static Stack stack2 = new Stack();
    public void push(int node) {
        stack1.push(node);
        if(stack2.size() == 0)
            stack2.push(node);
        else if((int)stack2.peek() <= node)
            stack2.push(stack2.peek());
        else if((int)stack2.peek() > node)
            stack2.push(node);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return (int)stack1.peek();
    }

    public int min() {
        return (int)stack2.peek();
    }
}