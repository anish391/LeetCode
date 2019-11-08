class Solution {
    private TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        return backtrack(root);
    }
    private boolean backtrack(TreeNode root){
        if(root!=null){
            if(!backtrack(root.left))
                return false;
            if(prev!=null && root.val<=prev.val)
                return false;
            prev = root;
            return backtrack(root.right);
        }
        return true;
    }
}



class Solution {
    //private TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        return backtrack(root, null, null);
    }
    private boolean backtrack(TreeNode root, Integer min, Integer max){
        if(root==null)
            return true;
        if((min!=null && root.val<=min)||(max!=null && root.val>=max))
            return false;
        return backtrack(root.left, min, root.val) && backtrack(root.right, root.val, max);
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
       if (root == null) 
           return true;
       Stack<TreeNode> stack = new Stack<>();
       TreeNode pre = null;
       while (root != null || !stack.isEmpty()) {
          while (root != null) {
             stack.push(root);
             root = root.left;
          }
          root = stack.pop();
          if(pre != null && root.val <= pre.val) 
              return false;
          pre = root;
          root = root.right;
       }
       return true;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        inorder(root, list);
        for(int i=0;i<list.size()-1;i++)
            if(!(list.get(i) <list.get(i+1)))
                return false;
        return true;
    }
    
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}