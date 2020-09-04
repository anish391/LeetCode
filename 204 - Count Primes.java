class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for(int i=2;i<n;i++)
            if(isPrime(i))
                count++;
        return count;
    }
    
    public boolean isPrime(int number){
        if(number<=1)
            return false;
        if(number<=3)
            return true;
        if(number%2==0 || number%3==0)
            return false;
        for(int i=5;i*i<=number;i++)
            if(number%i==0)
                return false;
        return true;
    }
}

class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for(int i=2;i<n;i++)
            if(isPrime(i))
                count++;
        return count;
    }
    
    public boolean isPrime(int number){
        if(number<=1)
            return false;
        if(number<=3)
            return true;
        if(number%2==0 || number%3==0)
            return false;
        for(int i=5;i*i<=number;i+=6)
            if(number%i==0 || number%(i+2) == 0)
                return false;
        return true;
    }
}