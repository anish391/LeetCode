class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0]=1;
        rightProduct[rightProduct.length-1]=1;
        for(int i=1;i<nums.length;i++)
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
        for(int i=nums.length-2;i>=0;i--)
            rightProduct[i] = rightProduct[i+1]*nums[i+1];
        //System.out.println(Arrays.toString(leftProduct));
        //System.out.println(Arrays.toString(rightProduct));
        for(int i=0;i<nums.length;i++)
            nums[i] = leftProduct[i]*rightProduct[i];
        return nums;
    }
}

2 2 3 4
l = 1 2 4 12
r = 24 12 4 1
n = 24 24 16 12

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // At index i contains product of numbers from 0 to i-1;
        int[] left = new int[nums.length];
        // At index i contains product of numbers from n to i+1;
        int[] right = new int[nums.length];
        // Contains product of left[i]*right[i]
        int[] result = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i=1;i<nums.length;i++)
            left[i] = left[i-1] * nums[i-1];
        for(int i=nums.length-2;i>=0;i--)
            right[i] = right[i+1] * nums[i+1];
        for(int i=0;i<nums.length;i++)
            result[i] = left[i] * right[i];
        return result;
    }   
}