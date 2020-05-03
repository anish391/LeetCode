class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]<prices[i])
                max += prices[i] - prices[i-1];
        }
        return max;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0 && prices!=null)
            return 0;
        int index = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        while(index<prices.length-1){
            while(index<prices.length-1 && prices[index]>=prices[index+1])
                index++;
            valley = prices[index];
            while(index<prices.length-1 && prices[index]<=prices[index+1])
                index++;
            peak = prices[index];
            maxProfit+=peak-valley;
        }
        return maxProfit;
    }
}