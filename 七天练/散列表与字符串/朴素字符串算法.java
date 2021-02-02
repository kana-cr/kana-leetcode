package 七天练.散列表与字符串;

public class 朴素字符串算法{
    
    public int nmatching(String subStr,String str){
        int i=0,j=0;
        while(i<subStr.length()&&j<str.length()){
            if(i==subStr.length()) return j-i;
            if(subStr.charAt(i)==str.charAt(j)){
                i++;
                j++;
            }else{
                i=i-j+1;
                j=0;
            }
        }
        return -1;
    }
}