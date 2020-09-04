// TLE Solution

class Solution {
    private int minFlips;
    public int minFlips(int[][] mat) {
        if(mat==null || mat.length==0 || mat[0].length==0)
            return 0;
        minFlips = Integer.MAX_VALUE;
        backtrack(mat, new HashSet<String>(), 0);
        return minFlips==Integer.MAX_VALUE?-1:minFlips;
    }
    
    public void backtrack(int[][] mat, Set<String> flipped, int flips){
        if(isFlipped(mat)){
            minFlips = Math.min(flips, minFlips);
            return;
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                String cell = i+","+j;
                if(!flipped.contains(cell)){
                    flipped.add(cell);
                    flip(mat, i, j);
                    backtrack(mat, flipped, flips+1);
                    flip(mat, i, j);
                    flipped.remove(cell);
                }
            }
        }
        
    }
    
    public boolean isFlipped(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=0)
                    return false;
            }
        }
        return true;
    }
    
    public void flip(int[][] mat, int row, int col){
        mat[row][col] = mat[row][col]==1?0:1;
        if(row-1>=0)
            mat[row-1][col] = mat[row-1][col]==1?0:1;
        if(row+1<mat.length)
            mat[row+1][col] = mat[row+1][col]==1?0:1;
        if(col-1>=0)
            mat[row][col-1] = mat[row][col-1]==1?0:1;
        if(col+1<mat[0].length)
            mat[row][col+1] = mat[row][col+1]==1?0:1;
    }
}


// DP Solution

class Solution {
    public int minFlips(int[][] mat) {
        if(mat==null || mat.length==0 || mat[0].length==0)
            return 0;
        int minFlips = Integer.MAX_VALUE;
        minFlips = backtrack(mat, new HashSet<String>(), new HashMap<String, Integer>());
        return minFlips==Integer.MAX_VALUE?-1:minFlips;
    }
    
    public int backtrack(int[][] mat, Set<String> previousStates, Map<String, Integer> dp){
        if(isFlipped(mat)){
            return 0;
        }
        StringBuilder matBuilder = new StringBuilder();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                matBuilder.append(mat[i][j]);
            }
        }
        String matString = matBuilder.toString();
        if(dp.containsKey(matString))
            return dp.get(matString);
        if(previousStates.contains(matString))
            return Integer.MAX_VALUE;
        int minFlips = Integer.MAX_VALUE;
        previousStates.add(matString);
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                flip(mat, i, j);
                int flips = backtrack(mat, previousStates, dp);
                if(flips!=Integer.MAX_VALUE)
                    minFlips = Math.min(minFlips, flips+1);
                flip(mat, i, j);
            }
        }
        previousStates.remove(matString);
        dp.put(matString, minFlips);
        return minFlips;
    }
    
    public boolean isFlipped(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=0)
                    return false;
            }
        }
        return true;
    }
    
    public void flip(int[][] mat, int row, int col){
        mat[row][col] = mat[row][col]==1?0:1;
        if(row-1>=0)
            mat[row-1][col] = mat[row-1][col]==1?0:1;
        if(row+1<mat.length)
            mat[row+1][col] = mat[row+1][col]==1?0:1;
        if(col-1>=0)
            mat[row][col-1] = mat[row][col-1]==1?0:1;
        if(col+1<mat[0].length)
            mat[row][col+1] = mat[row][col+1]==1?0:1;
    }
}