# Brute force solution

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] mcol = new int[n];
        int[] mrow = new int[n];
        for(int i=0;i<m;i++){
            int max = 0;
            for(int j=0;j<n;j++){
                if(grid[i][j]>=max)
                    max = grid[i][j];
            }
            mrow[i] = max;
        }
        for(int i=0;i<m;i++){
            int max = 0;
            for(int j=0;j<n;j++){
                if(grid[j][i]>=max)
                    max = grid[j][i];
            }
            mcol[i] = max;
        }
        for(int i:mrow)
            System.out.println(i);
        for(int i:mcol)
            System.out.println(i);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result = result+ (mrow[i]<mcol[j]?mrow[i]:mcol[j]) - grid[i][j]; 
            }
        }
        return result;
    }
}

#Concise and faster solution

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] mrow = new int[n];
        int[] mcol = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mrow[i] = Math.max(mrow[i],grid[i][j]);
                mcol[j] = Math.max(mcol[j],grid[i][j]);
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans += Math.min(mrow[i],mcol[j]) - grid[i][j];
            }
        }
        return ans;
    }
}