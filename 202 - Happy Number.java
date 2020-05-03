class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(set.add(n)){
            int squareSum = 0;
            while(n>0){
                int digit = n%10;
                squareSum+= digit*digit;
                n/=10;
            }
            if(squareSum==1)
                return true;
            else 
                n = squareSum;
        }
        return false;
    }
}