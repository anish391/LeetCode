class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<Double> avg = new ArrayList<Double>();
        if(root==null)
            return avg;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();
                sum+= current.val;
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
            }
            avg.add(sum/size);
        }
        return avg;
    }
}


class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sums = new ArrayList<Double>();
        List<Integer> count = new ArrayList<Integer>();
        averageOfLevels(root, 0, sums, count);
        for(int i=0;i<sums.size();i++){
            sums.set(i, sums.get(i)/count.get(i));
        }
        return sums; 
    }
    public void averageOfLevels(TreeNode root, int level, List<Double> sums, List<Integer> count){
        if(root==null)
            return;
        if(sums.size()>level){
            sums.set(level, sums.get(level)+root.val);
            count.set(level, count.get(level)+1);
        }
        else{
            sums.add(1.0*root.val);
            count.add(1);
        }
        averageOfLevels(root.left, level+1, sums, count);
        averageOfLevels(root.right, level+1, sums, count);
    }
}