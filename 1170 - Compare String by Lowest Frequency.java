class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length], w = new int[words.length];
        for(int i=0;i<q.length;i++)
            q[i] = freqMin(queries[i]);
        for(int i=0;i<w.length;i++){
            w[i] = freqMin(words[i]);
            //System.out.print(w[i]);
        }
        Arrays.sort(w);
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = 0, r=words.length-1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(w[mid]<=q[i])
                    l=mid+1;
                else
                    r=mid-1;
            }
            result[i] = w.length-l;
        }
        return result;
    }
    
    public int freqMin(String word){
        char minChar = 'z'+1;
        int count = 1;
        for(char c: word.toCharArray()){
            if(c<minChar){
                minChar = c;
                count = 1;
            }
            else if(c==minChar)
                count++;
        }
        return count;
    }
}

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] answer = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<words.length;j++){
                if(frequency(queries[i])<frequency(words[j]))
                    answer[i]++;
            }
        }
        return answer;
    }
    
    public int frequency(String s){
        int[] freqCount = new int[26];
        for(char c: s.toCharArray())
            freqCount[c-'a']++;
        int i=0;
        //System.out.println(Arrays.toString(freqCount));
        while(i<26){
            if(freqCount[i]>0)
                break;
            i++;
        }
        return freqCount[i];
    }
}