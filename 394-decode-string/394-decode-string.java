class Solution {
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        int[] endingBraketFor = new int[len];
        for(int i=0; i<len; i++){
            if(s.charAt(i) == '[')
                stack.add(i);
            else if(s.charAt(i) == ']')
                endingBraketFor[stack.pop()] = i;
        }
        return solve(s, len, 0, endingBraketFor);
    }
    private String solve(String s, int len, int start, int[] endingBraketFor){
        StringBuilder decoded = new StringBuilder();
        int k=0;
        for(int i=0; i<len; i++){
            if(Character.isDigit(s.charAt(i)))
                k = k*10 + (s.charAt(i) - '0');
            else if(s.charAt(i) == '['){
                int index = start+i;
                String sub = solve(s.substring(i+1, endingBraketFor[index] - start),
                                                endingBraketFor[index] - index -1,
                                                start+i+1, endingBraketFor);
                while(k-- > 0)
                    decoded.append(sub);
                k = 0;
                i = endingBraketFor[index] - start;
            }else{
                decoded.append(s.charAt(i));
            }
        }
        return decoded.toString();
    }
}