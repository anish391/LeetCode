// O(n^2)
class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int currentMax = Integer.MIN_VALUE;    
            for(int j=i+1;j<arr.length;j++){
                currentMax = Math.max(arr[j], currentMax);
            }
            arr[i] = currentMax;
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}


// O(n)
class Solution {
    public int[] replaceElements(int[] arr) {
        int currentMax = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            int currentValue = arr[i];
            arr[i] = currentMax;
            currentMax = Math.max(currentValue, currentMax);
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}