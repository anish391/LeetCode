class Solution {
    public int longestMountain(int[] A) {
        int base = 0, ans = 0;
        int N = A.length;
        while(base<N){
            int end = base;
            if(end<N-1 && A[end]<A[end+1]){
                while(end<N-1 && A[end]<A[end+1])
                    end++;
                if(end<N-1 && A[end]>A[end+1]){
                    while(end<N-1 && A[end]>A[end+1])
                        end++;
                    ans = Math.max(ans, end-base+1);
                }
            }
            base = Math.max(end, base+1);
        }
        return ans;
    }
}