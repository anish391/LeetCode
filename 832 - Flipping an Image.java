class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] row: A){
            for(int i=0;i<(row.length+1)/2;i++){
                int temp = row[i];
                row[i] = row[row.length-1-i]^1;
                row[row.length-1-i] = temp^1;
            }
        }
        return A;
    }
}