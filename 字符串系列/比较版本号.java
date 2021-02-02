package 字符串系列;

//比较两个版本号 version1 和 version2。
//如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
//你可以假设版本字符串非空，并且只包含数字和 . 字符。
// . 字符不代表小数点，而是用于分隔数字序列。
//例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
//你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。

public class 比较版本号 {

    public static int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < 4; i++) {
            if (v1.length - 1 < i || v2.length - 1 < i){
                if (v1.length - 1 < i && v2.length - 1 < i) {
                    return 0;
                } else if (v1.length - 1 < i ) {

                    while (i < v2.length){
                        if (!v2[i].equals("0"))
                            return -1;
                        i++;
                    }
                   break;
                }else if (v2.length - 1 < i ){

                    while (i < v1.length){
                        if (!v1[i].equals("0"))
                            return 1;
                        i++;
                    }
                    break;
                }

            }
            if (v1[i].equals("") || v2[i].equals("")){
                if (v1[i].equals("") && v2[i].equals(""))
                    continue;
                if (v1[i].equals("")) {
                    return -1;
                }else {
                    return 1;
                }
            }
           if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[i]))
               return 1;
            if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i]))
                return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000",
                "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"
        ));
    }

}
