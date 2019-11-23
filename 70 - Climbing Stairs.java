class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int climbStairs(int n) {
        return helper(0,n);
    }
    
    public int helper(int i,int n){
        if(map.containsKey(i))
            return map.get(i);
        if(i>n)
            return 0;
        if(i==n)
            return 1;
        map.put(i, helper(i+1,n)+helper(i+2,n));
        return map.get(i);
    }
}