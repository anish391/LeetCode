class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        leafSimilar(root1, list1);
        leafSimilar(root2, list2);
        if(list1.size()!=list2.size())
            return false;
        System.out.println(list1);
        System.out.println(list2);
        for(int i=0;i<list1.size();i++)
            if(list1.get(i)!=list2.get(i))
                return false;
        return true;
    }
    
    public void leafSimilar(TreeNode root, List<Integer> list){
        if(root!=null){
            if(root.left==null && root.right == null){
                list.add(root.val);
                return;
            }
            leafSimilar(root.left, list);
            leafSimilar(root.right, list);
        }
    }
}

## Stack Solution

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root1); s2.push(root2);
        while (!s1.empty() && !s2.empty())
            if (dfs(s1) != dfs(s2)) return false;
        return s1.empty() && s2.empty();
    }

    public int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
            if (node.left == null && node.right == null) return node.val;
        }
    }
}

