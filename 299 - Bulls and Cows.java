class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bulls = 0, cows=0;
        for(int i=0;i<secret.length();i++){
            int secretCharacter = Character.getNumericValue(secret.charAt(i));
            int guessCharacter = Character.getNumericValue(guess.charAt(i));
            if(secretCharacter == guessCharacter)
                bulls++;
            else{
                // If secret character was seen before in guess
                if(count[secretCharacter]<0)
                    cows++;
                // If guess character was seen before in secret.
                if(count[guessCharacter]>0)
                    cows++;
                count[secretCharacter]++;
                count[guessCharacter]--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}