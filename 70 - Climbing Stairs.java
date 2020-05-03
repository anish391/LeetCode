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

class Solution {
    public int climbStairs(int n) {
        return fibonacci(n, new int[n+1]);
    }
    
    public int fibonacci(int n, int[] memo){
        if(n==0 || n==1)
            return 1;
        if(n==2)
            return 2;
        else if(memo[n]!=0)
            return memo[n];
        memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo);
        return memo[n];
    }
}