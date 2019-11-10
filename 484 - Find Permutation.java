class Solution {
    public int[] findPermutation(String s) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[s.length()+1];
        int j = 0;
        for(int i=1;i<=s.length();i++){
            if(s.charAt(i-1)=='I'){
                stack.push(i);
                while(!stack.isEmpty())
                    result[j++] = stack.pop();
            }
            else{
                stack.push(i);
            }
        }
        stack.push(s.length() + 1);
        while (!stack.isEmpty())
            result[j++] = stack.pop();
        return result;
    }
}

class Solution {
    public int[] findPermutation(String s) {
        int[] result = new int[s.length()+1];
        for(int i=0;i<result.length;i++)
            result[i] = i+1;
        int i = 1;
        while(i<result.length){
            int j = i;
            while(i<result.length && s.charAt(i-1)=='D')
                i++;
            reverse(result, j-1, i);
            i++;
        }
        return result;
    }
    
    public void reverse(int[] arr, int l , int r){
        for(int i=0;i<(r-l)/2;i++){
            int temp = arr[i+l];
            arr[i+l] = arr[r-i-1];
            arr[r-i-1] = temp;
        }
    }
}