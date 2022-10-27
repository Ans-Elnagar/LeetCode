class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int open = 0;
        for(int i=0; i<len; i++){
            if(s.charAt(i) == '('){
                open++;
            }else if(s.charAt(i) == ')'){
                if(open == 0)
                    continue;
                open--;
            }
            sb.append(s.charAt(i));
        }
        
        s = sb.reverse().toString();
        sb = new StringBuilder();
        len = s.length();
        int close = 0;
        for(int i=0; i<len; i++){
            if(s.charAt(i) == ')'){
                close++;
            }else if(s.charAt(i) == '('){
                if(close == 0)
                    continue;
                close--;
            }
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}