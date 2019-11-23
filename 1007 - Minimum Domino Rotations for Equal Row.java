class Solution {
    public int check(int[] A, int[] B, int val){
        int rotationsA=0, rotationsB=0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=val && B[i]!=val)
                return -1;
            else if(A[i]==val && B[i]!=val)
                rotationsB++;
            else if(A[i]!=val && B[i]==val)
                rotationsA++;
        }
        return Math.min(rotationsA,rotationsB);
    }
    
    public int minDominoRotations(int[] A, int[] B) {
        int rotations = check(A,B,A[0]);
        if(rotations==-1)
            return check(A,B,B[0]);
        else 
            return rotations;
    }
}

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] nA=new int[6], nB=new int[6], same=new int[6];
        for(int i=0;i<A.length;i++){
            nA[A[i]-1]++;
            nB[B[i]-1]++;
            if(A[i]==B[i])
                same[A[i]-1]++;
        }
        // System.out.println(Arrays.toString(nA));
        // System.out.println(Arrays.toString(nB));
        // System.out.println(Arrays.toString(same));
        for(int i=0;i<6;i++){
            if(nA[i]+nB[i]-same[i]==A.length)
                return A.length-Math.max(nA[i],nB[i]);
        }
        return -1;
    }
}