class Solution {
    public int maxProduct(int[] nums) {
        int leftPrefixProduct = 0;
        int rightPrefixProduct = 0;
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            leftPrefixProduct = (leftPrefixProduct==0?1:leftPrefixProduct) * nums[i];
            rightPrefixProduct = (rightPrefixProduct==0?1:rightPrefixProduct)* nums[nums.length-1-i];
            result = Math.max(result, Math.max(leftPrefixProduct, rightPrefixProduct));
        }
        return result;
    }
}