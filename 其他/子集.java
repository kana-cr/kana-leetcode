package 其他;

import java.util.ArrayList;
import java.util.List;

public class 子集 {

    public List<List<Integer>> subsets(int[] nums) {
        //存放所有子集
        List<List<Integer>> res = new ArrayList<>();
        //子集总数共有 2^N 个
        int length = 1 << nums.length;
        //遍历所有的子集
        for (int i = 0; i < length; i++) {
            List<Integer> sub = new ArrayList<>();
            //对于 2^N 个 N 位的二进制数，我们可以通过从后往前的第 j 个二进制位的 0 和 1 来表示是否放入子集集合。
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            }

            res.add(sub);
        }
        return res;
    }

    List<List<Integer>> res;

    public List<List<Integer>> subsets_tree(int[] nums) {
        res = new ArrayList<>();
        dfs(nums,0,new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, int start, List<Integer> list) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
        res.add(new ArrayList<>(list));
    }
    }
