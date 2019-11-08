class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if(root==null)
            return true;
        queue.offer(root);
        TreeNode node = root;
        while(queue.peek()!=null){
            TreeNode current = queue.poll();
            queue.offer(current.left);
            queue.offer(current.right);
        }
        while(!queue.isEmpty() && queue.peek()==null)
            queue.poll();
        return queue.isEmpty();
    }
}