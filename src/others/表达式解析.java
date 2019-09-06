package others;

import java.util.Scanner;
import java.util.Stack;

/**
 * 表达式解析
 * @author yuyang
 * @create 2019-09-04 20:17
 * 豚厂给自研的数据库设计了一套查询表达式，在这个表达式中括号表示将里面的字符串翻转。请你帮助实现这一逻辑
 */
/*
((ur)oi)
iour
 */
public class 表达式解析 {
    public static String resolve(String expr){
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if(c == '(') stack.push('(');
            else if(c == ')'){
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop());
                if(stack.isEmpty()) return "";
                else{
                    stack.pop();
                    if(!stack.isEmpty()){
                        for (int j = 0; j < sb.length(); j++) {
                            stack.push(sb.toString().charAt(j));
                        }
                    }
                    else result.append(sb);
                }
            }
            else{
                if(stack.isEmpty()) result.append(c);
                else stack.push(c);
            }
        }
        if(!stack.isEmpty()) return "";
        else return result.toString();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
