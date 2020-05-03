class Solution {
    class Point{
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        Point l1 = new Point(rec1[0], rec1[1]);
        Point r1 = new Point(rec1[2], rec1[3]);
        Point l2 = new Point(rec2[0], rec2[1]);
        Point r2 = new Point(rec2[2], rec2[3]);
        if(r1.x<=l2.x || r2.x<=l1.x)
            return false;
        if(r1.y<=l2.y || r2.y<=l1.y)
            return false;
        return true;
    }
}