class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] frequency = new int[1000];
        for(int i=0;i<target.length;i++){
            frequency[target[i]-1]++;
            frequency[arr[i]-1]--;
        }
        for(int i=0;i<frequency.length;i++){
            if(frequency[i]!=0)
                return false;
        }
        return true;
    }
}