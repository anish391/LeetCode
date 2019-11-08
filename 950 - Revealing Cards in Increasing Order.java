class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] result = new int[deck.length];
        Arrays.sort(deck);
        for(int i=0;i<deck.length;i++){
            q.add(i);
        }
        for(int i=0;i<deck.length;i++){
            result[q.poll()] = deck[i];
            q.add(q.poll());
        }
        return result;
    }
}