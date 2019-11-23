class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int left=0, right=A.length-1;
        int max=Integer.MIN_VALUE;
        while(left<right){
            if(A[left]+A[right]>=K)
                right--;
            else{
                max = Math.max(max, A[left]+A[right]);
                left++;
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
}