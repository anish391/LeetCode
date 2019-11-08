#Time Out approach 77/84 test cases

class Solution {
    public int minDeletionSize(String[] A) {
        int count = 0;
        char ctr[] = new char[A[0].length()];
        int flag[] = new int[A[0].length()];
        for(int i=0;i<A[0].length();i++){
            ctr[i] = A[0].charAt(i);
            flag[i] = 0;
        }
        System.out.println(ctr.length);
        for(int j=1;j<A.length;j++){
            String s = A[j];
            for(int i=0;i<s.length();i++){
                if(ctr[i]>s.charAt(i))
                    flag[i] = 1;
                System.out.println(ctr[i]+" "+s.charAt(i));
                ctr[i] = s.charAt(i);
            }
        }
        for(int i: flag){
            if(i==1)
                count++;
        }
        return count;
    }
}

# Greedy Approach

class Solution {
    public int minDeletionSize(String[] A) {
        int count = 0;
        for(int i=0;i<A[0].length();i++){
            for(int j=0;j<A.length-1;j++){
                if(A[j].charAt(i)>A[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

