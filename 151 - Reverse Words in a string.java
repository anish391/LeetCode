class Solution {
    public String reverseWords(String s) {
        int left=0, right=s.length()-1;
        while(left<=right && s.charAt(left)==' ')
            left++;
        while(left<=right && s.charAt(right)==' ')
            right--;
        Deque<String> deque = new ArrayDeque();
        StringBuilder word = new StringBuilder();
        while(left<=right){
            char c = s.charAt(left);
            if(word.length()!=0 && c==' '){
                deque.offerFirst(word.toString());
                word = new StringBuilder();
            }
            else if(c!=' '){
                word.append(c);
            }
            left++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ", deque);
    }
}