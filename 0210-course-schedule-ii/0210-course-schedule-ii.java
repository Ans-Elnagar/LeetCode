class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> whoIsWaiting = new HashMap<>();
        Map<Integer, List<Integer>> waitingFor = new HashMap<>();
        for(int[] preq: prerequisites){
            if( ! whoIsWaiting.containsKey(preq[1]))
                whoIsWaiting.put(preq[1], new LinkedList<Integer>());
            if( ! waitingFor.containsKey(preq[0]))
                waitingFor.put(preq[0], new LinkedList<Integer>());
            whoIsWaiting.get(preq[1]).add(preq[0]);
            waitingFor.get(preq[0]).add(preq[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        // filling queue
        for(int i=0; i<numCourses; i++){
            if( ! waitingFor.containsKey(i)){
                queue.add(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while( ! queue.isEmpty() ){
            Integer node = queue.remove();
            order[index++] = node;
            if(whoIsWaiting.containsKey(node))
                for(Integer waiting: whoIsWaiting.get(node)){
                    waitingFor.get(waiting).remove(node);
                    if(waitingFor.get(waiting).isEmpty())
                        queue.add(waiting);
                }
        }
        if(index == numCourses)
            return order;
        return new int[0];
    }
}