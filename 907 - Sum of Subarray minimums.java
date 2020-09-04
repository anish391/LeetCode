class Solution {
    public int sumSubarrayMins(int[] A) {
        Stack<int[]> s1 = new Stack();
        Stack<int[]> s2 = new Stack();
        int result = 0;
        int mod = (int)1e9+7;
        // Elements to the left are strictly greater than current element.
        int[] left = new int[A.length];
        // Elements to the right are greater than current element.
        int[] right = new int[A.length];
        for(int i=0;i<A.length;i++){
            int count = 1;
            while(!s1.isEmpty() && s1.peek()[0] > A[i])
                count+=s1.pop()[1];
            s1.push(new int[]{A[i], count});
            left[i] = count;
        }
        for(int i=A.length-1;i>=0;i--){
            int count = 1;
            while(!s2.isEmpty() && s2.peek()[0] >= A[i])
                count+=s2.pop()[1];
            s2.push(new int[]{A[i], count});
            right[i] = count;
        }
        for(int i=0;i<A.length;i++){
            result=  (result+A[i]*left[i]*right[i]) % mod;
        }
        return result;
    }
}