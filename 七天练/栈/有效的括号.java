package 七天练.栈;

import java.util.Stack;

public class 有效的括号 {
    
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='(' || c=='[' || c=='{'){
            stack.push(c);
            }else if(c==')'||c==']'||c=='}'){

                if(stack.isEmpty())
                return false;

                if(stack.peek()=='('&&c==')'){
                    stack.pop();
                }else if(stack.peek()=='['&&c==']'){
                    stack.pop();
                }else if(stack.peek()=='{'&&c=='}'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}