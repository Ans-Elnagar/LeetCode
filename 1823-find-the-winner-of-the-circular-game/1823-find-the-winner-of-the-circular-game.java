class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] friends = new boolean[n];
        int start=0;
        while(n != 1){
            start = (start+k-1)%n;
            excludeFriend(friends, start);
            n--;
        }
        for(int i=0; i<friends.length; i++){
            if(! friends[i])
                return i+1;
        }
        return -1;
    }
    private void excludeFriend(boolean[] friends, int index){
        int i=0;
        for(; i<friends.length; i++){
            if(friends[i])
                continue;
            if(index == 0)
                break;
            index--;
        }
        friends[i] = true;
    }
}