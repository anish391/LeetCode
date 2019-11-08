# Slow Solution

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        if(root==null)
            return null;
        TreeNode n = root;
        while(n!=null){
            stack.push(n);
            n=n.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            node = node.right;
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
        }
        TreeNode curr = new TreeNode(list.get(0));
        TreeNode temp = curr;
        for(int i=1;i<list.size();i++){
            curr.right = new TreeNode(list.get(i));
            curr = curr.right;
        }
        return temp;
    }
}

## Slightly faster recursive solution

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        inorder(root,list);
        TreeNode curr = new TreeNode(list.get(0));
        TreeNode temp = curr;
        for(int i=1;i<list.size();i++){
            curr.right = new TreeNode(list.get(i));
            curr = curr.right;
        }
        return temp;
    }
    
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

## Brilliant Solution 

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail){
        if(root==null)
            return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
}