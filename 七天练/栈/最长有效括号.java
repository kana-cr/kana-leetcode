package 七天练.栈;

import java.util.Stack;

public class 最长有效括号 {
    
    //动态规划
    public int longestValidParentheses_dp(String s) {
    int maxLength = 0;
    int[] dp = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
        if(s.charAt(i) == ')'){
            if(s.charAt(i-1)=='('){
                dp[i]=(i>2?dp[i-2]:0)+2;
            }else{
                if(i-dp[i]-1>0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+ (i-dp[i-1]>=2?dp[i-dp[i-1]-2]:0)+2;
                }
            }
        }
        maxLength = Math.max(maxLength, dp[i]);
    }
        return maxLength;
    }


    //栈
    public int longestValidParentheses(String s) {

        if(s.isEmpty())
        return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else
                stack.pop();
                if(stack.isEmpty()){
                 stack.push(i);
                }else{
                   maxLength = Math.max(maxLength, i - stack.peek());
                }
            }

        return maxLength;
    }

    //计数器 
    public int longestValidParentheses_count(String s) {

        int left=0, right=0,maxLength=0;
        //左往右遍历 缺少类似(()的情况 右往左遍历弥补
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLength=Math.max(maxLength, right << 1);
            }else{
                if(right>left){
                    right=0;
                    left=0;
                }
            }
        }
        left=0;
        right=0;
        //右往左遍历
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLength=Math.max(maxLength, right << 1);
            }else{
                if(right>left){
                    right=0;
                    left=0;
                }
            }
        }
        return maxLength;
    }
}