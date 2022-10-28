class Trie {
    private static class Node{
        boolean isWord;
        Map<Character, Node> map;
        Node(){
            isWord = false;
            map = new HashMap<Character, Node>();
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        int len = word.length();
        for(int i=0; i<len; i++){
            if(! node.map.containsKey(word.charAt(i))){
                Node temp = new Node();
                node.map.put(word.charAt(i), temp);
            }
            node = node.map.get(word.charAt(i));
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        int len = word.length();
        for(int i=0; i<len; i++){
            if(! node.map.containsKey(word.charAt(i))){
                return false;
            }
            node = node.map.get(word.charAt(i));
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        int len = prefix.length();
        for(int i=0; i<len; i++){
            if(! node.map.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.map.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */