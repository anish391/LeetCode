class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList();
        int[][] count = new int[s.length()+1][26];
        for(int i=0;i<s.length();i++){
            count[i+1] = count[i].clone();
            count[i+1][s.charAt(i)-'a']++;
        }
        for(int[] query: queries){
            int sum = 0;
            for(int i=0;i<26;i++){
                sum+= (count[query[1]+1][i] - count[query[0]][i])%2;
            }
            result.add(sum/2 <= query[2]);
        }
        return result;
    }
}

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList();
        boolean[][] count = new boolean[s.length()+1][26];
        for(int i=0;i<s.length();i++){
            count[i+1] = count[i].clone();
            count[i+1][s.charAt(i)-'a'] ^= true;
        }
        for(int[] query: queries){
            int sum = 0;
            for(int i=0;i<26;i++){
                sum += (count[query[1]+1][i] ^ count[query[0]][i]) ? 1:0;
            }
            result.add(sum/2 <= query[2]);
        }
        return result;
    }
}