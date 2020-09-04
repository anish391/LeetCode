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
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> columnMap = new TreeMap();
        List<List<Integer>> result = new ArrayList();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList();
        // Initial column is 0. To go left we subtract 1 and to go right we add 1.
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();
            if(node!=null){
                if(!columnMap.containsKey(column))
                    columnMap.put(column, new ArrayList());
                columnMap.get(column).add(node.val);
                queue.offer(new Pair(node.left, column-1));
                queue.offer(new Pair(node.right, column+1));
            }
        }
        for(int key: columnMap.keySet()){
            result.add(columnMap.get(key));
        }
        return result;
    }
}

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
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> columnMap = new HashMap();
        List<List<Integer>> result = new ArrayList();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList();
        // Initial column is 0. To go left we subtract 1 and to go right we add 1.
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();
            if(node!=null){
                if(!columnMap.containsKey(column))
                    columnMap.put(column, new ArrayList());
                columnMap.get(column).add(node.val);
                queue.offer(new Pair(node.left, column-1));
                queue.offer(new Pair(node.right, column+1));
            }
        }
        List<Integer> columnKeyList = new ArrayList<Integer>(columnMap.keySet());
        Collections.sort(columnKeyList);
        for(int columnKey: columnKeyList)
            result.add(columnMap.get(columnKey));
        return result;
    }
}