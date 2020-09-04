/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);    
    }
    
    public Node construct(int[][] grid, int r, int c, int len){
        if(len==1){
            boolean val = grid[r][c]!=0;
            boolean isLeaf = true;
            return new Node(val, isLeaf);
        }
        Node topLeft = construct(grid, r, c, len/2);
        Node topRight = construct(grid, r, c+len/2, len/2);
        Node bottomLeft = construct(grid, r+len/2, c, len/2);
        Node bottomRight = construct(grid, r+len/2, c+len/2, len/2);
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf){
            if(topLeft.val && topRight.val && bottomLeft.val && bottomRight.val)
                return new Node(true, true);
            else if(!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val)
                return new Node(false, true);
        }
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}