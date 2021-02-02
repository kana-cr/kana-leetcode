package 七天练.散列表与字符串;

public class 字符串转换整数atoi {
    
    public int myAtoi(String s) {

        if (s == null|| s.trim().equals("")) return 0;
      
        int left = 0;
        //去除前面的空格
        while(left < s.length() && s.charAt(left)==' ')
        left++;
        StringBuilder builder = new StringBuilder();
        if(s.charAt(left)=='+'||s.charAt(left)=='-'){
         //正负符号
          char sign= s.charAt(left++);
         builder.append(sign);
        }
      
        if(left < s.length()){
        //判断第一个有效字符是否是数字
        if(s.charAt(left)<48 || s.charAt(left)>57){
            return 0;
        }else{
            //匹配到第一个字符不是数字为止
            while(left < s.length() && s.charAt(left)>=48 && s.charAt(left)<=57){
                builder.append(s.charAt(left++));
            }
            int index = 0;
            //去掉开头的0
            if(builder.charAt(0)=='-' || builder.charAt(0)=='+'){
               index++;
            }
            while(builder.length()>0 && builder.charAt(index) == '0' ){
              builder.deleteCharAt(index);
              if(builder.length()<1)
              return 0;
            }
            
        }
        try {
            if(builder.charAt(0) == '+' || builder.charAt(0) == '-'){
                return builder.charAt(0)=='-'? -Integer.valueOf(builder.substring(1).toString()):Integer.valueOf(builder.substring(1).toString());
              }else{
                  return Integer.valueOf(builder.toString());
              }
            
        } catch (NumberFormatException e) {
           if(builder.charAt(0) == '-')
           return Integer.MIN_VALUE;
      
           return Integer.MAX_VALUE;
        }
       
        }
        return 0;
      }
   
}