class Solution {
    public int oddEvenJumps(int[] A) {
        int result = 1;
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap();
        boolean[] oddJump = new boolean[n];
        boolean[] evenJump = new boolean[n];
        oddJump[n-1] = true;
        evenJump[n-1] = true;
        map.put(A[n-1], n-1);
        for(int i=n-2;i>=0;i--){
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> lo = map.floorEntry(A[i]);
            if(hi!=null)
                oddJump[i] = evenJump[hi.getValue()];
            if(lo!=null)
                evenJump[i] = oddJump[lo.getValue()];
            if(oddJump[i])
                result++;
            map.put(A[i], i);
        }
        return result;
    }
}