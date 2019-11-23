class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i=0;i<=num;i++)
            result[i] = popCount(i);
        return result;
    }
    
    public int popCount(int num){
        int count = 0;
        while(num!=0){
            if((num&1)==1)
                count++;
            num = num >>> 1;
        }
        return count;
    }
}

class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for(int i=0;i<=num;i++){
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;
    }
}

class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for(int i=1;i<=num;i++){
            dp[i] = dp[i&(i-1)] + 1;
        }
        return dp;
    }
}