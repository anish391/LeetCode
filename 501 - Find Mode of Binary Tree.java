/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, Integer> map = new HashMap();
    int maxCount = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root){
        inorder(root);
        List<Integer> list = new ArrayList();
        int max = Integer.MIN_VALUE;
        for(int i: map.keySet()){
            if(map.get(i)>=maxCount)
                list.add(i);
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public void inorder(TreeNode root) {
        if(root==null)
            return;
        inorder(root.left);
        if(map.getOrDefault(root.val,0)+1 > maxCount)
            maxCount = map.getOrDefault(root.val,0)+1;
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        inorder(root.right);
    }
}