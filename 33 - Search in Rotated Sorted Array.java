class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return -1;
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right])
                left=mid+1;
            else
                right=mid;
        }
        int start = left;
        left = 0;
        right = nums.length-1;
        if(target>=nums[start] && target<=nums[right])
            left = start;
        else 
            right = start;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high=nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int num = nums[mid];
            if(nums[0]>nums[mid] == nums[0]>target){
                num = nums[mid];
            }
            else{
                if(nums[0]>target)
                    num = Integer.MIN_VALUE;
                else
                    num = Integer.MAX_VALUE;
            }
            
            if(num<target)
                low=mid+1;
            else if(num>target)
                high=mid-1;
            else
                return mid;
        }
        return -1;
    }
}