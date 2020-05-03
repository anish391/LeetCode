class Solution {
    Map<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
    public int fib(int N) {
        if(N<2)
            return N;
        int[] arr = new int[N+1];
        arr[1] = 1;
        for(int i=2;i<=N;i++)
            arr[i] = arr[i-1] + arr[i-2];
        return arr[N];
    }
}

class Solution {
    //Map<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
    public int fib(int N) {
        int result;
        if(hashmap.containsKey(N))
            return hashmap.get(N);
        if(N<2)
            return N;
        result = fib(n-1) + fib(n-2);
        hashmap.put(N,result);
        return result;
    }
}

class Solution {
    public int fib(int N) {
        if(N<=1)
            return N;
        //int[] dp = new int[N+1];
        int a = 0;
        int b = 1;
        for(int i=2;i<=N;i++){
            int c = b+a;
            a = b;
            b = c;
        }
        return b;
    }
}