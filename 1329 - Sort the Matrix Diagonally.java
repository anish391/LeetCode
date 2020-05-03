class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> diagonalMap = new HashMap();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                diagonalMap.putIfAbsent(i-j, new PriorityQueue<Integer>());
                diagonalMap.get(i-j).add(mat[i][j]);
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j] = diagonalMap.get(i-j).poll();
            }
        }
        return mat;
    }
}