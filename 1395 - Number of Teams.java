class Solution {
    public int numTeams(int[] rating) {
        int teams = 0;
        for(int i=0;i<rating.length-2;i++){
            for(int j=i+1;j<rating.length-1;j++){
                for(int k=j+1;k<rating.length;k++){
                    if(rating[i]<rating[j]&& rating[j]<rating[k] || rating[i]>rating[j]&&rating[j]>rating[k])
                        teams++;    
                }
            }
        }
        return teams;
    }
}


class Solution {
    public int numTeams(int[] rating) {
        int result = 0;
        for(int j=0;j<rating.length;j++){
            int lesserLeft=0, lesserRight=0;
            int greaterLeft=0, greaterRight=0;
            for(int i=0;i<j;i++){
                if(rating[j]>rating[i])
                    lesserLeft++;
                else if(rating[j]<rating[i])
                    greaterLeft++;
            }
            for(int k=j+1;k<rating.length;k++){
                if(rating[j]>rating[k])
                    lesserRight++;
                else if(rating[j]<rating[k])
                    greaterRight++;
            }
            result+=lesserLeft*greaterRight+lesserRight*greaterLeft;
        }
        return result;
    }
}