class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color!=newColor)
            helper(image,sr,sc,color,newColor);
        return image;
    }
    
    public void helper(int[][] image, int sr, int sc, int color, int newColor){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=color)
            return;
        image[sr][sc] = newColor;
        helper(image, sr-1,sc, color, newColor);
        helper(image, sr+1,sc, color, newColor);
        helper(image, sr,sc+1, color, newColor);
        helper(image, sr,sc-1, color, newColor);
    }
}