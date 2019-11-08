class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] answer = new int[m+n];
        for(int i=m-1;i>-1;i--){
            for(int j=n-1;j>-1;j--){
                int p1 = i+j;
                int p2 = i+j+1;
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = mul + answer[p2];
                answer[p1] += sum/10;
                answer[p2] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i: answer){
            if(i!=0 || sb.length()!=0)
                sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}