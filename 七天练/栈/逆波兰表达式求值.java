package 七天练.栈;

import java.util.Stack;

//根据 逆波兰表示法，求表达式的值。
//有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//整数除法只保留整数部分。
//给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况
public class 逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int ans1 = stack.pop();
                int ans2 = stack.pop();
                stack.push(calculation(ans1, ans2, tokens[i]));
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }   
        return stack.pop();
    }

 private int calculation(int a,int b,String s){
    if(s.equals("+")){
            return a+b;
     }else if(s.equals("-")){
            return a-b;
    }else if(s.equals("*")){
            return a*b;
     }else if(s.equals("/"))
            return a/b;
        
            return 0;
    }

 
}