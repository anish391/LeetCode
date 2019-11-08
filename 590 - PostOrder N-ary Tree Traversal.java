# Recursive Solution

class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root==null)
            return list;
        for(Node node: root.children){
            postorder(node);
        }
        list.add(root.val);
        return list;
    }
}

# Less Memory Recursive Solution

class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        po(root);
        return list;
    }
    
    public void po(Node root){
        if(root==null)
            return;
        for(Node node: root.children){
            postorder(node);
        }
        list.add(root.val);
    }
}

# Iterative Solution

class Solution {
    
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if(root==null)
            return list;
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            for(Node n: node.children){
                stack.add(n);
            }
        }
        Collections.reverse(list);
        return list;
    }
}