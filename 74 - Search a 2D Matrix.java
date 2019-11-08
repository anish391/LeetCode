class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;
        int low = 0;
        int high = totalRows*totalColumns-1;
        while(low<=high){
            int middle = low+(high-low)/2;
            int middleElementValue = matrix[middle/totalColumns][middle%totalColumns];
            if(middleElementValue == target)
                return true;
            else if(middleElementValue<target)
                low = middle+1;
            else 
                high = middle-1;
        }
        return false;
    }
}