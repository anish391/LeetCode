// Merge Sort

class Solution {
    public List<Integer> sortArray(int[] nums) {
        nums = mergeSort(nums);
        List<Integer> result = new ArrayList();
        for(int i: nums)
            result.add(i);
        return result;
    }
    
    public int[] mergeSort(int[] nums){
        if(nums.length==1)
            return nums;
        int mid = nums.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(nums,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums,mid,nums.length));
        return merge(left, right);
    }
    
    public int[] merge(int[] left, int[] right){
        int[] ans = new int[left.length+right.length];
        int index = 0;
        int l=0,r=0;
        while(l<left.length && r<right.length){
            if(left[l]<=right[r])
                ans[index++] = left[l++];
            else
                ans[index++] = right[r++];
            
        }
        while(l<left.length)
            ans[index++] = left[l++];
        while(r<right.length)
            ans[index++] = right[r++];
        return ans;
    }
}