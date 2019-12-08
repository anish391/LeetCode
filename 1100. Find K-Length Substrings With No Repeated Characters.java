class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int count = 0;
        if(S.length()==0||S.length()<K)
            return count;
        for(int i=0;i<S.length()-K+1;i++){
            boolean[] arr = new boolean[26];
            int j;
            for(j=i;j<i+K;j++){
                int c = S.charAt(j)-'a';
                if(arr[c])
                    break;
                arr[c] = true;
            }
            if(j-i==K)
                count++;
        }
        return count;
    }
}