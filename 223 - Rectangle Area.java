class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D-B)*(C-A);
        int area2 = (G-E)*(H-F);
        int left = Math.max(A,E);
        int right = Math.max(Math.min(C,G), left);
        int bottom = Math.max(B,F);
        int top = Math.max(Math.min(D,H),bottom);
        int area3 = (left-right)*(bottom-top);
        return area1+area2-area3;
    }
}