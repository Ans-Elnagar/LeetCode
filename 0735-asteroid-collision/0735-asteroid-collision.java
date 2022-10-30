class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        for(int a: asteroids){
            if(a > 0){
                stack.push(a);
            }else{
                a *= -1;
                while(!stack.isEmpty() && stack.peek() < a){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    list.add(-1*a);
                }else if(stack.peek().equals(a))
                    stack.pop();
            }
        }
        int[] result = new int[list.size()+stack.size()];
        int i=0;
        for(Integer a: list)
            result[i++] = a;
        for(Integer a: stack)
            result[i++] = a;
        return result;
    }
}