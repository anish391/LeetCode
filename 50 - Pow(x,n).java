import java.util.*;
class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n==1)
            return x;
        double res;
        double temp = myPow(x,Math.abs(n/2));
        res = temp*temp;
        if(n%2!=0)
            res *= x;
        return n<1 ? 1/res:res;
    }
}