class Solution {
    public int[] sortArrayByParityII(int[] A) {
        Deque<Integer> os = new LinkedList<Integer>();
        Deque<Integer> es = new LinkedList<Integer>();
        for(int i: A){
            if(i%2==0)
                es.push(i);
            else
                os.push(i);
        }
        for(int i=0;i<A.length;i++){
            if(i%2==0)
                A[i] = es.pop();
            else
                A[i] = os.pop();
        }
        return A;
    }
}

## Second Solution using second Array

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;
        for(int x: A){
            if(x%2==0){
                ans[t] = x;
                t+=2;
            }
        }
        t=1;
        for(int x: A){
            if(x%2==1){
                ans[t] = x;
                t+=2;
            }
        }
        return ans;
    }
}

# Third Solution in place

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int j=1;
        for(int i=0;i<A.length;i+=2){
            if(A[i]%2==1){
                while(A[j]%2==1){
                    j+=2;
                }
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }
}