class Solution {
    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();
        str = str.replaceAll(" ","");
        if(str.length()==0 || str.charAt(0)=='.'){
            System.out.println("A");
            return 0;
        }           
        if((!Character.isDigit(str.charAt(0)) && (str.charAt(0)!='-'&&str.charAt(0)!='+'))){
            System.out.println("B");
            if(str.length()==1 && (str.charAt(0)=='-'||str.charAt(0)=='+')){
                System.out.println("C");
                return 0;
            }
            return 0;
        }
        
        System.out.println(str);
        for(char c: str.toCharArray()){
            if(c=='.')
                break;
            
            if(Character.isDigit(c))
                sb.append(c);
        }
        try{
            return str.charAt(0)=='-'? -Integer.parseInt(sb.toString()):Integer.parseInt(sb.toString());    
        }
        catch(NumberFormatException e){
            return str.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        
    }
}