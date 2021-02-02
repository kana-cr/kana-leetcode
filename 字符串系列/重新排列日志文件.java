package 字符串系列;

import java.util.Arrays;

//你有一个日志数组 logs。每条日志都是以空格分隔的字串。
//对于每条日志，其第一个字为字母与数字混合的 标识符 ，除标识符之外的所有字为这一条日志的 内容 。
//    除标识符之外，所有字均由小写字母组成的，称为 字母日志
//    除标识符之外，所有字均由数字组成的，称为 数字日志
//题目所用数据保证每个日志在其标识符后面至少有一个字。
//请按下述规则将日志重新排序：
//    所有 字母日志 都排在 数字日志 之前。
//    字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序；
//    数字日志 应该按原来的顺序排列。
//返回日志的最终顺序。
public class 重新排列日志文件 {

    //数字排列部分未完成
    public static String[] reorderLogFiles_err(String[] logs) {
        if (logs == null || logs.length == 0 )
            return logs;
        int index = logs.length - 1;
        for (int i = 0; i < logs.length; i++) {
            if (index == i){
                break;
            }
            String log = logs[i];
            String[] logPart = log.split(" ");
            //是数字日志
            if (Character.isDigit(logPart[1].charAt(0))){
                //最后方是数字 往前进一位
                while (Character.isDigit(logs[index].split(" ")[1].charAt(0))){
                    index--;
                    if (index == i) {
                        if (index == 0)
                            return logs;
                       i = logs.length;
                       break;
                    }
                }
                if (i == logs.length)
                    break;
              String s = logs[index];
              logs[index] = logs[i];
              logs[i] = s;
              index--;
                //回溯
              i--;
            }
        }
        //index += 1;
     /*   //需要翻转后面的数字日志
        for (int i = index  , j = 0; i < logs.length; i++ , j++) {
            if (logs.length - j == i)
                break;
            String s = logs[index];
            logs[index] = logs[logs.length - 1 - j];
            logs[logs.length - 1 - j] = s;
        }*/
        int charLength = index - 1;
        // 处理字母日志
        for (int i = 0; i < index; i++) {

                String log = logs[i];
                String[] logPart = log.split(" ",2);


                    //从最后一段字母日志开始比较
                    for (int l = charLength; l > i ; l--) {
                        String[] lastLog = logs[l].split(" ",2);
                        int result = logPart[1].compareTo(lastLog[1]);
                        //后面相等 比较标识符
                        if (result == 0){
                            result = logPart[0].compareTo(lastLog[0]);
                            if (result > 0){
                                String newLog = logs[l];
                                logs[l] = log;
                                logs[i] = newLog;
                                i--;
                                break;
                            }
                            //前者大
                        }else if (result > 0){
                            String newLog = logs[l];
                            logs[l] = log;
                            logs[i] = newLog;
                            i--;
                            break;
                        }else {
                            continue;
                        }
                    }


        }
        return logs;
    }
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {//运用到了java里的泛型，第二个参数重新定义排序规则
            String[] split1 = log1.split(" ", 2); //将log1 按分隔符“ ” ，分成2份，即把标识符分开来
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));//判断除标识符外的第一个字符是数字true，字母false
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) { //如果两个日志都是字母日志
                int cmp = split1[1].compareTo(split2[1]); //先比较内容字母split1>split2则返回1，等于返0，小于返-1
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);//若内容字母相同则比较标识符
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            //如果split1是数字字符，且split2是数字字符返回0，
            // 如果split1是数字字符，且split2是字母字符返回1，即split1>split2,从小到大排序，split2提前
            // 如果split1是字母字符，返回-1，
        });
        return logs;
    }
    public static void main(String[] args) {
        String[] logs = new String[5];
        logs[0] = "1 n u";
        logs[1] = "r 527";
        logs[2] = "j 893";
        logs[3] = "6 14";
        logs[4] = "6 82";
      logs = reorderLogFiles_err(logs);
        System.out.println(Arrays.toString(logs));
    }
}
