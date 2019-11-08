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
    Map<TreeNode, TreeNode> map = new HashMap();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parentMap(root, null);
        Queue<TreeNode> queue = new LinkedList();
        Set<TreeNode> set = new HashSet();
        int layerSize = 0;
        queue.offer(target);
        set.add(target);
        while(!queue.isEmpty()){
            if(K == layerSize)
                return queueAsList(queue);
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null && !set.contains(node.left)){
                    set.add(node.left);
                    queue.offer(node.left);
                }
                if(node.right!=null && !set.contains(node.right)){
                    set.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode parentOfNode = map.get(node);
                if(parentOfNode!=null && !set.contains(parentOfNode)){
                    set.add(parentOfNode);
                    queue.offer(parentOfNode);
                }
            }
            layerSize++;
        }
        return new ArrayList<Integer>();
    }
    
    public void parentMap(TreeNode root, TreeNode parent){
        if(root==null)
            return;
        map.put(root, parent);
        parentMap(root.left, root);
        parentMap(root.right, root);
    }
    
    public List<Integer> queueAsList(Queue<TreeNode> queue){
        List<Integer> list = new ArrayList();
        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;
    }
}