class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i=0;i<nums.length-1;i+=2){
            int freq = nums[i];
            int num = nums[i+1];
            for(int j=0;j<freq;j++){
                list.add(num);
            }
        }
        int[] result = new int[list.size()];
        int i=0;
        for(int num:list)
            result[i++] = num;
        return result;
    }
}