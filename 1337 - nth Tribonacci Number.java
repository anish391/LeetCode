class Solution {
    public int tribonacci(int n) {
        return helper(n);
    }
    
    public int helper(int n){
        if(n<=0)
            return 0;
        else if(n<=2)
            return 1;
        else 
            return helper(n-1) + helper(n-2) + helper(n-3);
    }
}

class Solution {
    public int tribonacci(int n) {
        if(n<2)
            return n;
        int a=0,b=1,c=1;
        int d;
        while(n>2){
            d=a+b+c;
            a=b;
            b=c;
            c=d;
            n--;
        }
        return c;
    }
}