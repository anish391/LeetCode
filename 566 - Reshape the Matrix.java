// Basic Solution
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int currentRow = nums.length;
        int currentCol = nums[0].length;
        if(r*c!=currentRow*currentCol)
            return nums;
        else{
            int index = 0;
            int[] list = new int[r*c];
            for(int i=0;i<currentRow;i++){
                for(int j=0;j<currentCol;j++){
                    list[index++] = nums[i][j];
                }
            }
            nums = new int[r][c];
            index = 0;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    nums[i][j] = list[index++];
                }
            }
            return nums;
        }
    }
}

// O(1) space solution

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int currentRow = nums.length;
        int currentCol = nums[0].length;
        if(r*c!=currentRow*currentCol)
            return nums;
        else{
            int[][] result = new int[r][c];
            int row=0,col=0;
            for(int i=0;i<currentRow;i++){
                for(int j=0;j<currentCol;j++){
                    result[row][col] = nums[i][j];
                    col++;
                    if(col==c){
                        row++;
                        col=0;
                    }
                }
            }
            return result;
        }
    }
}

// O(1) space solution

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int currentRow = nums.length;
        int currentCol = nums[0].length;
        if(r*c!=currentRow*currentCol)
            return nums;
        else{
            int[][] result = new int[r][c];
            int count=0;
            for(int i=0;i<currentRow;i++){
                for(int j=0;j<currentCol;j++){
                    result[count/c][count%c] = nums[i][j];
                    count++;
                }
            }
            return result;
        }
    }
}

