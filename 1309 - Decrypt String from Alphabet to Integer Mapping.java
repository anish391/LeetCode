class Solution {
    public String freqAlphabets(String s) {
        int index = s.length()-1;
        StringBuilder sb = new StringBuilder();
        char[] map = new char[26];
        for(int i=0;i<26;i++)
            map[i] = (char)('a'+i);
        System.out.println(Arrays.toString(map));
        int i = s.length()-1;
        while(i>=0){
            if(s.charAt(i)=='#'){
                i--;
                int times = 2;
                int number = 0;
                int multiplier = 1;
                while(i>=0 && times>0){
                    number += Character.getNumericValue(s.charAt(i))*multiplier;
                    i--;
                    times--;
                    multiplier*=10;
                }
                sb.insert(0, map[number-1]);
            }
            else{
                sb.insert(0, map[Character.getNumericValue(s.charAt(i))-1]);
                i--;
            }
        }
        
        return sb.toString();
    }
}