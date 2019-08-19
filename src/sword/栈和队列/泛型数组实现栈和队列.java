package sword.栈和队列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyang
 * @create 2019-08-11 9:59
 */
public class 泛型数组实现栈和队列 {
    //类的命名ArrayStack
    public static class ArrayStack<E> {
        //数组的定义使用成员变量，不直接new,在构造方法中new并且对数组进行大小的限定
        private List<E>[] arr;
        //
        private Integer size;

        //用构造方法对数组大小进行定义，对成员变量进行初始化
        //行参的命名initSize
        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            List[] list = new List[initSize];
            arr = list;
            size = 0;
        }

        //模拟返回栈顶元素
        public List<E> peek() {
            //一定要考虑边界情况
            if (size == 0) {
                return null;
            }

            return arr[size - 1];
        }

        //模拟入栈操作
        public void push(List<E> obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[size++] = obj;
        }

        public List<E> pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--size];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;
            last = last == arr.length - 1 ? 0 : last + 1;
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[tmp];
        }
    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(10);
        List<String> list1 = new ArrayList<>();
        list1.add("112");
        stack.push(list1);
        List<String> list2 = stack.pop();
        for (String s : list2) {
            System.out.println(s);
        }
    }
}