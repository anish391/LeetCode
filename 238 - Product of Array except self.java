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