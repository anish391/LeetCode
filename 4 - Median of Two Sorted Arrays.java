class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int low = 0;
        int high = nums1.length;
        int x = nums1.length;
        int y = nums2.length;
         if (x > y) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if(x==0)
            return y%2==0?(double)(nums2[nums2.length/2-1]+nums2[nums2.length/2])/2:(double)nums2[nums2.length/2];
        else if(y==0)
            return x%2==0?(double)(nums1[nums1.length/2-1]+nums1[nums1.length/2])/2:(double)nums1[nums1.length/2];
        while(low<=high){
            int partitionX = (low+high)/2; // 
            int partitionY = (x+y+1)/2 - partitionX; // 
            
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE:nums1[partitionX-1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE:nums1[partitionX];
            
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE:nums2[partitionY-1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE:nums2[partitionY];
            
            if(maxLeftX<=minRightY && maxLeftY <= minRightX){
                if((x+y)%2==0)
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                else
                    return (double)Math.max(maxLeftX, maxLeftY);
            }
            else if(maxLeftX > minRightY)
                high = partitionX-1;
            else
                low = partitionX+1;
            
        }
        return -1;
    }
}