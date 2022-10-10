class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1, j = t.length()-1;
        while(true){
            int ignoreChars = 0;
            while( i>=0 && (ignoreChars > 0 || s.charAt(i) == '#')){
                if(s.charAt(i) == '#'){
                    ignoreChars++;
                }else{
                    ignoreChars--;
                }
                i--;
            }
            ignoreChars = 0;
            while( j>=0 && (ignoreChars > 0 || t.charAt(j) == '#')){
                if(t.charAt(j) == '#'){
                    ignoreChars++;
                }else{
                    ignoreChars--;
                }
                j--;
            }
            if(i < 0 || j < 0)
                break;
            if(s.charAt(i) != t.charAt(j))
                break;
            i--;
            j--;
        }
        return i == -1 && j == -1;
    }
}