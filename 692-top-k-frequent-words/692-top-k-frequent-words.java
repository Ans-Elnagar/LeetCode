class Solution {
    private static class Node{
        String word;
        int count;
        Node(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n0, Node n1) {
                if(n0.count != n1.count)
                    return n1.count - n0.count;
                return n0.word.compareTo(n1.word);
            }
        });
        for(String word: map.keySet()){
            heap.add(new Node(word, map.get(word)));
        }
        List<String> list = new LinkedList<>();
        while(k-->0){
            list.add(heap.poll().word);
        }
        return list;
    }
}