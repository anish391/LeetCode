class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList();
        Set<String> deadendSet = new HashSet(Arrays.asList(deadends));
        Set<String> visited = new HashSet();
        String lock = "0000";
        visited.add(lock);
        queue.offer(lock);
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String current = queue.poll();
                if(current.equals(target))
                    return moves;
                if(deadendSet.contains(current))
                    continue;
                for(int j=0;j<4;j++){
                    char ch = current.charAt(j);
                    int slotChangeUp = slotChange(ch, true);
                    String slotUp = current.substring(0,j)+slotChangeUp+current.substring(j+1);
                    if(!visited.contains(slotUp) && !deadendSet.contains(slotUp)){
                        queue.offer(slotUp);
                        visited.add(slotUp);
                    }
                    int slotChangeDown = slotChange(ch, false);
                    String slotDown = current.substring(0,j)+slotChangeDown+current.substring(j+1);
                    if(!visited.contains(slotDown) && !deadendSet.contains(slotDown)){
                        queue.offer(slotDown);
                        visited.add(slotDown);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    
    public int slotChange(char ch, boolean isUp){
        if(isUp){
            return ch=='9'?0:(ch-'0'+1);
        }
        else{
            return ch=='0'?9:(ch-'0'-1);
        }
            
    }
}