class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                int profit = prices[j] - prices[i];
                if(profit>maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}


# Faster Solution

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min)
                min = prices[i];
            else if(prices[i]-min>max)
                max = prices[i] - min;
        }
        return max;
    }
}