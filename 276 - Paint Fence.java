class Solution {
    public int numWays(int n, int k) {
        if(n==0)
            return 0;
        if(n==1)
            return k;
        if(n==2)
            return k*k;
        int same = k;
        int different = k*(k-1);
        for(int i=3;i<=n;i++){
            int prevDifferent = different;
            different = (same+different)*(k-1);
            same = prevDifferent;
        }
        return same+different;
    }
}