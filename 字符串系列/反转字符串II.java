package 字符串系列;

//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//    如果剩余字符少于 k 个，则将剩余字符全部反转。
//    如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
public class 反转字符串II {

    public static String reverseStr(String s, int k) {
        int count = 2 * k ;
        int size = s.length();
        StringBuilder sd = new StringBuilder(s);
        for (int i = 0; i < size; i++) {
            //count--;
            int remain = size - (i + 1);
            while (size != 0 && size % count > 0 && size % count != size){
                size -= count;
                i += count;
                StringBuilder repl = new StringBuilder(sd.substring(i - 2 * k, i - k ));
                sd.replace(i - 2 * k,i - k , repl.reverse().toString());
                 remain = s.length() - (i + 1);

            }
            if (size == 0)
                break ;
           if (remain < k){
                   StringBuilder repl = new StringBuilder(sd.substring(i));
                   sd.replace(i,s.length(), repl.reverse().toString());
                break;
            }else if (remain < 2 * k && remain >= k){
               StringBuilder repl = new StringBuilder(sd.substring(i, i + k ));
               sd.replace(i ,i + k , repl.reverse().toString());
               break;
            }

        }
        return sd.toString();
    }

    public static void main(String[] args) {
        reverseStr("krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc",20);
        reverseStr("abcd",3);

    }
}
