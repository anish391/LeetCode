/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //System.out.println(preorder(root, false));
        return preorder(root,false);
    }
    
    public String preorder(TreeNode root, boolean left){
        if(root==null)
            return "X";
        return root.val+"#"+preorder(root.left, true)+"#"+preorder(root.right, false);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList();
        queue.addAll(Arrays.asList(data.split("#")));
        TreeNode root = deserialize(queue);
        return root;
    }
    
    public TreeNode deserialize(Queue<String> queue){
        String nodeVal = queue.poll();
        if(nodeVal.equals("X"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodeVal));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));