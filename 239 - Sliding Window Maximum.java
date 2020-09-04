class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k==0)
            return new int[0];
        int[] result = new int[nums.length-k+1];
        int resultIndex = 0;
        for(int i=0;i<nums.length-k+1;i++){
            int max = nums[i];
            for(int j=i;j<i+k ;j++)
                max = Math.max(max, nums[j]);
            result[resultIndex++] = max;
        }
        return result;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums==null || nums.length==0 || k==0)
            return new int[0];
        LinkedList<Integer> queue = new LinkedList();
        int[] result = new int[nums.length-(k-1)];
        int resultIndex=0;
        for(int i=0;i<nums.length;i++){
            // Remove numbers to the left of current window from queue.
            while(!queue.isEmpty() && queue.peek() < i-(k-1))
                queue.poll();
            // Remove numbers from end queue less than current number.
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.poll();
            queue.offer(i);
            if(i>=k-1)
                result[resultIndex++] = nums[queue.peek()];
        }
        return result;
    }
}
