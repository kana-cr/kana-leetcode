package 字符串系列;

import java.util.*;

//每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
//例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
//除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
//如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
//如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
//可以同时使用这两个规则。
//给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
public class 独特的电子邮件地址 {

    public int numUniqueEmails(String[] emails) {
        if(emails.length < 1) return 0;

        Set<String> set = new HashSet<>();
        for(String str : emails){
            String[] strs = str.split("@");
            String sb = strs[0];
            String temp ="";
            for(int i = 0;i < sb.length(); i++){
                if(sb.charAt(i) == '.') continue;
                else if(sb.charAt(i) == '+') break;
                else temp += sb.charAt(i);
            }
            temp += "@"+strs[1];
            set.add(temp);
        }
        return set.size();
    }
/*    public int numUniqueEmails_stream(String[] emails){
        return (int) Arrays.stream(emails).map(a1 ->
        {
            a1 = a1.replaceAll("\+.*@", "@");
        while (a1.matches(".*\..*@.*")) { a1 = a1.replaceFirst("\.", "");
        } return a1; }).distinct().count();
    }*/
}
