class Solution {
    public String interpret(String command) {
        int len = command.length();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<len; i++){
            if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')' ){
                    i++;
                    result.append("o");
                }else{
                    i += 3;
                    result.append("al");
                }
            }else{
                result.append("G");
            }
        }
        return result.toString();
    }
}