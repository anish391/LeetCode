class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        if(n%2==1){
            result[index++] = 0;   
            for(int i=index;i<=n/2;i++){
                result[index++] = i;
                result[index++] = -i;
            }
        }
        else{
            for(int i=index+1;i<=n/2;i++){
                result[index++] = i;
                result[index++] = -i;
            }
        }
         
        return result;
    }
}