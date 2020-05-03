class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] count = new int[1001];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++)
            count[A[i]]++;
        for(int i=0;i<count.length;i++){
            if(count[i]==1)
                max = Math.max(max, i);
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
}