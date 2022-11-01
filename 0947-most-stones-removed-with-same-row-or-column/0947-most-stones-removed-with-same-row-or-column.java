class Solution {
    class UnionFind{
        final int N = 20001;
        int rank[]=new int[N],parn[]=new int[N];
        void makeSet(){
            for(int i=0;i<N;i++){
                rank[i]=0;
                parn[i]=i;
            }
        }
        int findParent(int nd){
            if(nd==parn[nd])
                return nd;
            return parn[nd]=findParent(parn[nd]);
        }
        void unionSet(int a, int b){
            int pa=findParent(a),pb=findParent(b);
            if(rank[pa]==rank[pb]){
                rank[pa]++;
                parn[pb]=pa;
            }else if(rank[pa]<rank[pb])
                parn[pa]=pb;
            else parn[pb]=pa;
        }
        UnionFind() {makeSet();}
    }
    
    public int removeStones(int[][] stones) {
        UnionFind ob = new UnionFind();
        for(int[] coor: stones){
            if(ob.findParent(coor[0]) != ob.findParent(coor[1]+10000))
                ob.unionSet(coor[0],coor[1]+10000);
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int stonesLeft=0;
        for(int[] coor: stones){
            if(!set.contains(ob.findParent(coor[0]))){
                set.add(ob.findParent(coor[0]));
                stonesLeft++;
            }
        }
        return stones.length-stonesLeft;
    }
}