class Solution {
    public boolean checkPerfectNumber(int num) {
        int count =0;
        if(num==0)
            return false;
        for(int i=1;i<num/2+1;i++){
            if(num%i==0)
                count+=i;
        }
        return count==num;
    }
}