class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        Deque<Node> deque = new ArrayDeque<Node>();
        List<List<Node>> list = new ArrayList<List<Node>>();
        deque.offer(root);
        while(!deque.isEmpty()){
            LinkedList<Node> level = new LinkedList<Node>();
            int size = deque.size();
            for(int i=0;i<size;i++){
                Node node = deque.poll();
                level.add(node);
                if(node.left!=null)
                    deque.offer(node.left);
                if(node.right!=null)
                    deque.offer(node.right);
            }
            for(int i=0;i<level.size()-1;i++){
                if(level.size()==1)
                    break;
                Node n1 = level.get(i);
                Node n2 = level.get(i+1);
                n1.next = n2;
            }
        }
        return root;
    }
}


## Iterative Quick

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        Node curr = root;
        while(curr.left!=null){
            Node nextLeft = curr.left;
            while(curr!=null){
                curr.left.next = curr.right;
                curr.right.next = curr.next==null?null:curr.next.left;
                curr = curr.next;
            }
            curr = nextLeft;
        }
        return root;
    }
}

## Recursive

class Solution {
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    
    public void helper(Node root){
        if(root==null)
            return;
        if(root.left!=null){
            root.left.next = root.right;
            if(root.next!=null)
                root.right.next = root.next.left;
        }
        helper(root.left);
        helper(root.right);
    }
}