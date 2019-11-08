#DFS based approach

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        return levelOrder(root, 0, new ArrayList<List<Integer>>());
    }
    
    public List<List<Integer>> levelOrder(Node root, int level, List<List<Integer>> tree){
        if(root==null)
            return null;
        List<Integer> list = tree.size() > level ? tree.get(level) : new ArrayList<Integer>();
        list.add(root.val);
        if(tree.size()<=level)
            tree.add(list);
        for(Node n: root.children){
            levelOrder(n, level+1, tree);
        }
        return tree;
    }
}

# Queue Based Approach

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null)
            return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                Node current = queue.poll();
                for(Node n: current.children)
                    queue.add(n);
                level.add(current.val);
            }
            list.add(level);
        }
        return list;
    }
}