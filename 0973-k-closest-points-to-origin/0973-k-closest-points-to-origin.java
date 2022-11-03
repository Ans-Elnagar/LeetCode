class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(
                                (int[] p1, int[] p2)->dist(p2)-dist(p1));
        for(int i=0; i<points.length; i++){
            pQueue.add(points[i]);
            if(pQueue.size() > k)
                pQueue.remove();
        }
        points = new int[k][];
        for(int i=0; i<k; i++){
            points[i] = pQueue.remove();
        }
        return points;
    }
    
    private int dist(int[] p){
        return p[0]*p[0] + p[1]*p[1];
    }
}