class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        double num = 1;
        list.add(1);
        rowIndex++;
        for(int i=1; i<rowIndex; i++){
            num *= (rowIndex-i)/(double)i;
            list.add((int)Math.round(num));
        }
        return list;
    }
}