class Solution {
    public String pushDominoes(String dominoes) {
        char[] domino = dominoes.toCharArray();
        Set<Integer> indices = new HashSet<>();
        Set<Integer> future = new HashSet<>();
        for(int i=0; i<domino.length; i++){
            if(domino[i] != '.')
                indices.add(i);
        }
        while( ! indices.isEmpty() ){
            for( Integer index: indices ){
                if(domino[index] == 'L'){
                    int next = index-1;
                    if(next < 0)
                        continue;
                    if(future.contains(next)){
                        future.remove(next);
                        domino[next] = '.';
                        continue;
                    }
                    if(domino[next] != '.')
                        continue;
                    domino[next] = 'L';
                    future.add(next);
                    
                }else if(domino[index] == 'R'){
                    int next = index+1;
                    if(next >= domino.length)
                        continue;
                    if(future.contains(next)){
                        future.remove(next);
                        domino[next] = '.';
                        continue;
                    }
                    if(domino[next] != '.')
                        continue;
                    domino[next] = 'R';
                    future.add(next);
                }
            }
            indices.clear();
            Set<Integer> temp = indices;
            indices = future;
            future = temp;
        }
        return new String(domino);
    }
}