class Solution {
    public String interpret(String command) {
        Map<String, String> map = new HashMap<>();
        map.put("G", "G");
        map.put("()", "o");
        map.put("(al)", "al");
        int len = command.length();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<len; i++){
            if(command.charAt(i) == '('){
                String segment = "";
                for(; i<len; i++){
                    segment += command.charAt(i);
                    if(command.charAt(i) == ')'){
                        result.append(map.get(segment));
                        break;
                    }
                }
            }else{
                result.append("G");
            }
        }
        return result.toString();
    }
}