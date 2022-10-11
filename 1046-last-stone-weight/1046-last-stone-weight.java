class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        for(int stone: stones){
            heap.add(stone);
        }
        while(heap.size() >= 2){
            int remaining = heap.poll() - heap.poll();
            if(remaining > 0)
                heap.add(remaining);
        }
        if(heap.size() == 1)
            return heap.poll();
        return 0;
    }
}