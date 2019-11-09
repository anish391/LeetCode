class Solution {
    public int reverse(int x) {
        String s = Integer.toString(x);
        boolean flag = s.charAt(0)=='-' ? true:false;
        if(flag)
            s=s.substring(1);
        int len = s.length()-1;
        StringBuilder sb = new StringBuilder();
        while(len>=0){
            sb.append(s.charAt(len--));
        }
        if(flag)
            sb.insert(0,'-');
        try{
            return Integer.parseInt(sb.toString());    
        }
        catch(NumberFormatException e){
            return 0;
        }
        
    }
}

class Solution {
    public int reverse(int x) {
        int result = 0;
        while(x!=0){
            int t = x%10;
            x /= 10;
            if((result > Integer.MAX_VALUE/10) || ((result==Integer.MAX_VALUE/10) && t >7))
                return 0;
            if((result < Integer.MIN_VALUE/10) || ((result==Integer.MIN_VALUE/10) && t <-8))
                return 0;
            result = result*10 + t;
        }
        return result;
    }
}

