class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap();
        Map<Integer, Integer> indegree = new HashMap();
        // Create the graph here.
        for(List<Integer> seq: seqs){
            // If seq is size 1, it has no children/neighbours.
            if(seq.size()==1){
                int u = seq.get(0);
                if(!graph.containsKey(u)){
                    graph.put(u, new HashSet());
                    indegree.put(u, 0);       
                }
            }
            else{
                for(int i=0;i<seq.size()-1;i++){
                    int u = seq.get(i);
                    int v = seq.get(i+1);
                    // Initialize adjacency and indegree lists for u and v.
                    if(!graph.containsKey(u)){
                        graph.put(u, new HashSet());
                        indegree.put(u, 0);
                    }
                    if(!graph.containsKey(v)){
                        graph.put(v, new HashSet());
                        indegree.put(v, 0);
                    }
                    // Create link u -> v and update indegree
                    if(graph.get(u).add(v)){
                        indegree.put(v, indegree.get(v)+1);
                    }    
                }
            }
        }
        Queue<Integer> queue = new LinkedList();
        // If indegree is 0 i.e. root node, add to queue.
        for(int node: indegree.keySet()){
            if(indegree.get(node)==0)
                queue.offer(node);
        }
        
        int index = 0; 
        while(!queue.isEmpty()){
            int size = queue.size();
            // If queue is greater than one, means two possible children from previous node.
            if(size>1)
                return false;
            int currentNode = queue.poll();
            // Check if index is already the size of the original sequence length.
            // Check if currentNode does not match the current original sequence node.
            if(index==org.length || org[index++]!=currentNode)
                return false;
            for(int nextNode: graph.get(currentNode)){
                indegree.put(nextNode, indegree.get(nextNode)-1);
                if(indegree.get(nextNode)==0)
                    queue.offer(nextNode);
            }
        }
        // If the subsequence is greater/lesser than original sequence, return false
        return index==org.length && index==graph.size();
    }
}