class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int count = 0;
        for(int i=0;i<calories.length;i++){
            count+=calories[i];
            if(i>=k-1){
                if(i>k-1)
                    count-=calories[i-k];
                if(count<lower)
                    points--;
                else if(count>upper)
                    points++;
            }
        }
        return points;
    }
}