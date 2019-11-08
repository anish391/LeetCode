# Iterative Solution BFS
class Solution {
    public int maxDepth(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        if(root==null)
            return 0;
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node current = queue.poll();
                for(Node n: current.children){
                    queue.offer(n);
                }
            }
            count++;
        }
        return count;
    }
}

## Faster Recursive Solution

class Solution {
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        int max = 0;
        for(Node n: root.children){
            int value = maxDepth(n);
            max = value>max?value:max;
        }
        return max+1;
    }
}