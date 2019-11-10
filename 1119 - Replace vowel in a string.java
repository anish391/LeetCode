class Solution {
    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]","");
    }
}

class Solution {
    public String removeVowels(String S) {
        Set<Character> set = new HashSet();
        char[] vowels = {'a','e','i','o','u'};
        for(char c: vowels)
            set.add(c);
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()){
            if(!set.contains(c))
                sb.append(c);
        }
        return sb.toString();
    }
}