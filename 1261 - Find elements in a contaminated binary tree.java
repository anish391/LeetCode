/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

    private TreeNode root;
    
    public FindElements(TreeNode root) {
        this.root = root;
        dfs(root, 0); 
    }
    
    public void dfs(TreeNode root, int value){
        if(root==null)
            return;
        root.val = value;
        dfs(root.left, (value*2)+1);
        dfs(root.right, (value*2)+2);
    }
    
    public boolean find(int target) {
        String tree = serialize(target+1);
        return find(this.root, tree, 1);
    }
    
    public boolean find(TreeNode root, String tree, int index){
        if(root==null)
            return false;
        if(index==tree.length())
            return true;
        return tree.charAt(index)=='0'?find(root.left, tree, index+1):find(root.right, tree, index+1);
    }
    
    public String serialize(int target){
        StringBuilder sb = new StringBuilder();
        while(target>0){
            sb.append(target&1);
            target/=2;
        }
        return sb.reverse().toString();
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */