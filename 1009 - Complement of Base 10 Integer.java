class Solution {
    public int bitwiseComplement(int N) {
        String s = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='1')
                sb.append(0);
            else if(c=='0')
                sb.append(1);
        }
        return Integer.parseInt(sb.toString(),2);
    }
}

class Solution {
    public int bitwiseComplement(int n) {
        int allBitsSet = (int)Math.pow(2,0);
        for(int i=1;allBitsSet<n;i++)
            allBitsSet+=Math.pow(2,i);
        return n^allBitsSet;
    }
}
}