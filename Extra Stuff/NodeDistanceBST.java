public class NodeDistanceBST {
    static class Node{
        private Node left,right;
        private int val;
        Node(int val){
            this.val = val;
        }
    }

    public static Node insertNode(Node root, int val){
        if(root==null)
            root = new Node(val);
        else if(val<=root.val)
            root.left = insertNode(root.left, val);
        else
            root.right = insertNode(root.right,val);
        return root;
    }

    public static int distanceFromCurrent(Node root, int val){
        if(root.val == val)
            return 0;
        if(root.val>=val)
            return 1+distanceFromCurrent(root.left,val);
        else
            return 1+distanceFromCurrent(root.right,val);
    }

    public static int findDistance(Node root, int left, int right){
        if(root==null)
            return 0;
        if(root.val<left && root.val<right)
            return findDistance(root.left,left,right);
        if(root.val>left && root.val>right)
            return findDistance(root.right,left,right);
        if(root.val>=left && root.val<=right)
            return distanceFromCurrent(root,left) + distanceFromCurrent(root, right);
        return 0;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root, 20);
        insertNode(root, 10);
        insertNode(root, 5);
        insertNode(root, 15);
        insertNode(root, 30);
        insertNode(root, 25);
        insertNode(root, 35);
        System.out.println(root.left.val);
        System.out.println(root.left.left.val);
        System.out.println(findDistance(root, 5, 35));
    }
}
