class Solution {
    public int sumOfDigits(int[] A) {
        int minElement = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            minElement = Math.min(A[i], minElement);
        }
        int sum = 0;
        while(minElement!=0){
            int digit = minElement%10;
            sum+=digit;
            minElement/=10;
        }
        return sum%2==1?0:1;
    }
}