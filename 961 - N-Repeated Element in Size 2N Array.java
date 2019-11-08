class Solution {
    public int repeatedNTimes(int[] A) {
        for(int k=1;k<=3;++k){
            for(int i=0;i<A.length-k;i++){
                System.out.println(k);
                if(A[i]==A[i+k]){
                    return A[i];
                }
            }
        }
        return 0;
    }
}

