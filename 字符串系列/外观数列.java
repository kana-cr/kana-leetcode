package 字符串系列;

public class 外观数列 {

    public static String countAndSay(int n) {
        String str = "1";
        if (n == 1)
            return str;

        for (int i = 1; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            int count = 0;
            int index = str.charAt(0) - 48;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) - 48 == index) {
                    count++;
                    if (j == str.length() - 1){
                        builder.append(count);
                        builder.append(index);
                        count = 0;
                    }
                }else {
                    builder.append(count);
                    builder.append(index);
                    index = str.charAt(j) - 48;
                    count = 1;
                    if (j == str.length() - 1){
                        builder.append(1);
                        builder.append(index);
                    }
                }

            }

            str = builder.toString();
        }
        return str;
    }

    public static void main(String[] args) {
      countAndSay(7);
    }

}
