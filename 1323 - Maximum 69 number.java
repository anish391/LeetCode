class Solution {
    public int maximum69Number (int num) {
        int max = num;
        int original = num;
        int multiplier = 1;
        while(num!=0){
            int d = num%10;
            int temp = original;
            if(d==6){
                temp = temp-6*multiplier+9*multiplier;
                max = Math.max(temp,max);
            }
            num/=10;
            multiplier*=10;
        }
        return max;
    }
}

class Solution {
    public int maximum69Number (int num) {
        char[] number = Integer.toString(num).toCharArray();
        for(int i=0;i<number.length;i++){
            if(number[i]=='6'){
                number[i]='9';
                break;
            }
        }
        return Integer.parseInt(new String(number));
    }
}