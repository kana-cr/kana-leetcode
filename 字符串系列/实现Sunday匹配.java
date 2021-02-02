package 字符串系列;

//实现 strStr() 函数。
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
public class 实现Sunday匹配 {

    //使用Sunday匹配
    //    对齐目标串和模式串，从前向后匹配
    //    关注主串中位于模式串后面的第一个元素（核心）
    //    如果关注的字符没有在子串中出现则直接跳过
    //    否则开始移动模式串，移动位数 = 子串长度 - 该字符最右出现的位置(以0开始)
    private static int strStr_Sunday(String haystack, String needle){
        if (haystack == null || needle == null) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        //目标串匹配索
        int haystackIndex = 0;
        //模式串匹配索引
        int needleIndex = 0;
        // 成功匹配完终止条件：所有needle均成功匹配
        while (needleIndex<needle.length()){
            // 针对haystack匹配完，但needle未匹配完情况处理 如 mississippi sippia
            if (haystackIndex>haystack.length()-1){
                return -1;
            }
            if (haystack.charAt(haystackIndex)==needle.charAt(needleIndex)) {
                // 匹配则index均加1
                haystackIndex++;
                needleIndex++;
            }else {
                int nextCharIndex=haystackIndex-needleIndex+needle.length();
                //判断下一个目标字符是否存在。
                if (nextCharIndex<haystack.length()){
                    // 判断目标字符在模式串中匹配到，返回最后一个匹配的index
                    int step=needle.lastIndexOf(haystack.charAt(nextCharIndex));
                    if (step == -1) {
                        // 不存在的话，设置到目标字符的下一个元素
                        haystackIndex=nextCharIndex+1;
                    }else {
                        // 存在的话，移动对应的数字
                        haystackIndex=haystackIndex-step;
                    }
                    //模式串总是从第一个开始匹配
                    needleIndex=0;
                }else {
                    return -1;
                }
            }
        }
        return haystackIndex-needleIndex;
    }

    //使用回溯
    private static int strStr(String haystack, String needle) {
        if (needle == null || haystack == null ||"".equals(needle))
            return 0;
        char[] origin_arr = haystack.toCharArray();
        char[] aim_arr = needle.toCharArray();
        int record = 0;
        int index = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (origin_arr[i] == aim_arr[index]) {
                if (index == 0)
                    record = i;
                index++;
            } else {
                if (index!=0)
                    i-=index;
                index = 0;
            }
            if (index==needle.length()){
                return record;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        //System.out.println(strStr("abcabcd","abcd"));
    }
}
