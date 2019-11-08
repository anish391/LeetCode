class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if(root==null)
            return list;
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            List<Node> nd = node.children;
            Collections.reverse(nd);
            for(Node n: nd){
                stack.push(n);
            }
        }
        return list;
    }
}