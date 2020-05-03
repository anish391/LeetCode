class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList();
        int[] rowMin = new int[matrix.length];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        int[] colMin = new int[matrix[0].length];
        //Arrays.fill(colMin, Integer.MAX_VALUE);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMin[j] = Math.max(colMin[j], matrix[i][j]);
            }
        }
        for(int i=0;i<rowMin.length;i++){
            for(int j=0;j<colMin.length;j++){
                if(rowMin[i]==colMin[j])
                    result.add(rowMin[i]);
            }
        }
        return result;
    }
}