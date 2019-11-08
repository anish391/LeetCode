class Solution {
    public int peakIndexInMountainArray(int[] A) {
        return func(A, 0, A.length-1);
    }
    
    public int func(int[] arr, int left, int right){
        if(left<=right){
            int mid = (left + right) / 2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid]<arr[mid+1])
                return func(arr, mid+1,right);
            else if(arr[mid]<arr[mid-1])
                return func(arr, left, mid-1);
        }
        
        return -1;
    }
}