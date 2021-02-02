package 字符串系列;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
public class 括号生成 {


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list,"",0,0 , n);
        return list;
    }

    public void generate(List<String> ans,String str,int leftCount , int rightCount,int n){
        if (leftCount > n || rightCount >n)
            return;
        if (leftCount == n && rightCount == n) {
            ans.add(str);
            return;
        }
        if (leftCount >= rightCount){
            generate(ans,str + ")" ,leftCount ,rightCount + 1 ,n);
        }else {
            generate(ans, str + "(", leftCount + 1, rightCount, n);
        }
    }

    List<String> res = new ArrayList<>();
    //dfs + 剪枝
    public List<String> generateParenthesis_dfs(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
}
