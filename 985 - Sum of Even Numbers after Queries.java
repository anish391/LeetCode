class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int index = 0;
        int[] result = new int[A.length];
        //List<Integer> list = new ArrayList();
        for(int i=0;i<queries.length;i++){
            A[queries[i][1]] += queries[i][0];
            int sum = 0;
            for(int j: A)
                sum+= j%2==0?j:0;
            result[i] = sum;
        }
        return result;
    }
}


## Faster Solution
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] ans = new int[A.length];
        for(int i: A)
            if(i%2==0)
                sum+=i;
        for(int i=0;i<queries.length;i++){
            int val = queries[i][0];
            int index = queries[i][1];
            if(A[index]%2==0)
                sum-=A[index];
            A[index] += val;
            if(A[index]%2==0)
                sum+=A[index];
            ans[i] = sum;
        }
        return ans;
    }
}