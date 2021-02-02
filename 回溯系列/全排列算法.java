package 回溯系列;

import java.util.ArrayList;
import java.util.List;

//什么是全排列？
// 从 n 个不同元素中任取 m（m≤n）个元素，按照一定的顺序排列起来，叫做从 n 个不同元素中取出 m 个元素的一个排列。
// 当 m=n 时所有的排列情况叫全排列。
public class 全排列算法 {

 /**
     result = []
     def backtrack(路径, 选择列表):
     if 满足结束条件:
     result.add(路径)
     return
     for 选择 in 选择列表:
     做选择
     backtrack(路径, 选择列表)
     撤销选择
 **/

    //给定一个没有重复数字的序列，返回其所有可能的全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(ans, list, nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int num : nums) {
            if(!list.contains(num)) {
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
