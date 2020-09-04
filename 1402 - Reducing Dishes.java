class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int result = 0;
        int totalSoFar = 0;
        int len = satisfaction.length-1;
        for(int i=len;i>=0 && satisfaction[i]+totalSoFar>0;i--){
            // Because of totalSoFar, the result will be updated accordingly with multiples of numbers.
            totalSoFar += satisfaction[i];
            result += totalSoFar;
        }
        return result;
    }
}

/*
[-8,-7,-1,0,5] total=0
i=4 => A[i]=5  A[i]+total>0 total= 5, result= 5;
i=3 => A[i]=0  A[i]+total>0 total= 5, result= 10;
i=2 => A[i]=-1 A[i]+total>0 total= 4, result= 14;
i=1 => A[i]=-7 A[i]+total<0 break
*/