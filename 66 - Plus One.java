# My Approach

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length-1;
        if(digits[digits.length-1]!=9){
            digits[n]++;
            return digits;
        }
        else{
            int temp [] = {};
            if(digits[0]==9){
                temp = new int[digits.length+1];
                int i = n;
                while(i>-1 && digits[i]==9){
                    temp[i+1] = 0;
                    i--;
                }
                temp[i+1]++;
            }
            else{
                temp = new int[digits.length];
                int i = n;
                while(i>0 && digits[i]==9){
                    temp[i] = 0;
                    i--;
                }
                temp[i] = digits[i]+1;
                i--;
                while(i>-1){
                    temp[i] = digits[i];
                    i--;
                }
            }
            return temp;
        } 
        
    }
}

# Smaller approach 
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length-1;
        for(int i=n;i>-1;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] temp = new int[digits.length+1];
        temp[0] = 1;
        return temp;
    }
}
