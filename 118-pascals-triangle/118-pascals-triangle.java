class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new LinkedList<>();
        List<Integer> row = new LinkedList<>();
        row.add(1);
        List<Integer> prevRow = row;
        allRows.add(row);
        numRows--;
        while(numRows-->0){
            row = new LinkedList<Integer>();
            int prevValue = 0;
            for(Integer value: prevRow){
                row.add(prevValue + value);
                prevValue = value;
            }
            row.add(1);
            prevRow = row;
            allRows.add(row);
        }
        return allRows;
    }
}