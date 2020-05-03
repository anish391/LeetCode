class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
            A[i] = A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }
}

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] squaredArray = new int[A.length];
        int index = squaredArray.length-1;
        int left=0, right=index;
        while(left<=right){
            if(Math.abs(A[left])>Math.abs(A[right])){
                squaredArray[index--] = A[left]*A[left];
                left++;
            }
            else{
                squaredArray[index--] = A[right]*A[right];
                right--;
            }
        }
        return squaredArray;
    }
}