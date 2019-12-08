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
    List<Integer> list = new ArrayList();
    public void recoverTree(TreeNode root) {
        inorder(root);
        int[] swappedValues = findSwappedValues();
        //System.out.println(Arrays.toString(swappedValues));
        swap(root,2,swappedValues[0],swappedValues[1]);
        //return root;
    }
    
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    public int[] findSwappedValues(){
        int x=-1,y=-1;
        //System.out.println(list);
        for(int i=0;i<list.size()-1;i++){
            //System.out.println(i+" "+x+" "+y);
            if(list.get(i)>list.get(i+1)){
                y= list.get(i+1);
                if(x==-1)
                    x=list.get(i);
                else 
                    break;
            }
        }
        return new int[]{x,y};
    }
    
    public void swap(TreeNode root, int count, int x, int y){
        if(root==null)
            return;
        swap(root.left,count,x,y);
        if(root.val == x || root.val == y){
            root.val = root.val==x?y:x;
            count--;
            if(count==0)
                return;
        }
        swap(root.right,count,x,y);
    }
    
}


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
    TreeNode x=null, y=null, previous=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(x,y);
    }
    
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        if(previous!=null && root.val<previous.val){
            y = root;
            if(x==null)
                x = previous;
            else 
                return;
        }
        previous = root;
        inorder(root.right);
    }
    
    public void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}