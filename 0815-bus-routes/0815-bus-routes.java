class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<routes.length; i++){
            for(int dist: routes[i]){
                if(! map.containsKey(dist))
                    map.put(dist, new LinkedList<Integer>());
                map.get(dist).add(i);
            }
        }
        if(!map.containsKey(source))
            return -1;
        boolean[] visited = new boolean[1000_000];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        int jumps = 1;
        visited[source] = true;
        boolean[] visitedRoutes = new boolean[routes.length];
        while(!queue.isEmpty()){
            int sz = queue.size();
            while(sz-->0){
                int current = queue.remove();
                for(Integer route: map.get(current)){
                    if(visitedRoutes[route])
                        continue;
                    visitedRoutes[route] = true;
                    for(int dist: routes[route]){
                        if(!visited[dist]){
                            visited[dist] = true;
                            if(dist == target)
                                return jumps;
                            queue.add(dist);
                        }
                    }
                }
            }
            jumps++;
        }
        return -1;
    }
}