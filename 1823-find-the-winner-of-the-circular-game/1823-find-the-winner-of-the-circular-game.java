class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++)
            queue.add(i);
        for(int i=1; i<n; i++){
            int temp = k;
            while(temp>0){
                int friend = queue.remove();
                temp--;
                if(temp == 0)
                    break;
                queue.add(friend);
            }
        }
        return queue.remove();
    }
}