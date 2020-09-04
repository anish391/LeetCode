class Solution {
    
    private LinkedList<String> result;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList();
        Map<String, PriorityQueue<String>> graph = new HashMap();
        for(List<String> ticket: tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue destinations = graph.getOrDefault(from, new PriorityQueue<String>());
            destinations.offer(to);
            graph.put(from, destinations);
            //graph.computeIfAbsent(from, k->new PriorityQueue<String>()).offer(to);
        }
        dfs("JFK", graph);
        return result;
    }
    
    public void dfs(String from, Map<String, PriorityQueue<String>> graph){
        while(graph.get(from)!=null && !graph.get(from).isEmpty()){
            String to = graph.get(from).poll();
            dfs(to, graph);
        }
        result.addFirst(from);
    }
}