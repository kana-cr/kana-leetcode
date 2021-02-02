package 七天练.回溯;



public class 正则表达式匹配 {

    public boolean isMatch_api(String s, String p) {
        return s.matches(p);
    }

    private boolean matched = false;

    public boolean isMatch(String s, String p) {
        
       rmatch(0,0,s, p);
       return matched;

    }
    private void rmatch(int ti,int pj,String s , String pattern){
        if(matched) return;// 如果已经匹配了，就不要继续递归了
        if(pj == pattern.length()){// 正则表达式到结尾了
            if(ti == s.length()){//文本串也到结尾了
                matched = true;
            } return;
        }
        
        if( pj < pattern.length() - 1 && pattern.charAt(pj + 1) == '*'){// .*匹配任意个字符
            if(pattern.charAt(pj)== '.'){
                for (int i = 0; i <= s.length() - ti; i++) {
                    rmatch(ti + i, pj + 1, s, pattern);
                }
            }
            else if(pattern.charAt(pj)==s.charAt(ti)){
                //匹配0次
                rmatch(ti, pj + 2, s, pattern);
                //匹配一次并在这里结束这次匹配
                rmatch(ti + 1, pj + 2, s, pattern);
                //继续进行匹配
                rmatch(ti + 1, pj, s, pattern);
                
            }else{
                if(pj < pattern.length() - 2) rmatch(ti, pj + 2, s, pattern);
            }
           
        }else if(pattern.charAt(pj) == '.'){
            rmatch(ti + 1, pj + 1, s, pattern);
        }else if(ti < s.length() && pattern.charAt(pj) == s.charAt(ti)){
            rmatch(ti + 1, pj + 1, s, pattern);
        }


    }
}