/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList();
        Map<Node, Node> map = new HashMap();
        if(node==null)
            return node;
        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList()));
        while(!queue.isEmpty()){
            Node n = queue.poll();
            for(Node neighbor: n.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.offer(neighbor);
                }
                map.get(n).neighbors.add(map.get(neighbor));
                
            }
        }
        return map.get(node);
    }
}