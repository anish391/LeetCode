class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        //int[][] dp = new int[arr1.length][arr2.length];
        int result = 0;
        for(int i=0;i<arr1.length;i++){
            int n1 = arr1[i];
            boolean hasDistanceValue = true;
            for(int j=0;j<arr2.length;j++){
                int n2 = arr2[j];
                if(Math.abs(n1-n2)<=d){
                    hasDistanceValue = false;
                    break;
                }
            }
            if(hasDistanceValue)
                result++;
        }
        return result;
    }
}