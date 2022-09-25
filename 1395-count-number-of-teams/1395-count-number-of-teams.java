class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        for(int i=0; i<rating.length; i++){
            int leftLarger=0, leftSmaller=0;
            int rightLarger=0, rightSmaller=0;
            for(int j=0; j<i; j++){
                if(rating[j] > rating[i])
                    leftLarger++;
                else
                    leftSmaller++;
            }
            for(int j=i+1; j<rating.length; j++){
                if(rating[j] > rating[i])
                    rightLarger++;
                else
                    rightSmaller++;
            }
            count += leftLarger * rightSmaller + leftSmaller * rightLarger;
        }
        return count;
    }
}