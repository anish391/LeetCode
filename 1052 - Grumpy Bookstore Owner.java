class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied=0, maxWindowX=0;
        int windowX = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)
                satisfied+=customers[i];
            else
                windowX+=customers[i];
            if(i>=X)
                windowX-=customers[i-X]*grumpy[i-X];
            maxWindowX = Math.max(maxWindowX, windowX);
        }
        return satisfied+maxWindowX;
    }
}