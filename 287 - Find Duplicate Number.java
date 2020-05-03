class Solution {
    public int findDuplicate(int[] nums) {
        //boolean[] visited = new boolean[nums.length];
        Set<Integer> set = new HashSet();
        for(int i: nums){
            if(set.contains(i))
                return i;
            set.add(i);
        }
        return -1;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Set<Integer> set = new HashSet();
        for(int i: nums){
            if(visited[i])
                return i;
            visited[i] = true;
        }
        return -1;
    }
}

//Brilliant solution
class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0)
                return Math.abs(nums[i]);
            nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        return -1;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do{
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }while(hare!=tortoise);
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while(ptr1!=ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}