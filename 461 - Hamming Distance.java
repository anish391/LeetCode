class Solution {
    public int hammingDistance(int x, int y) {
        String a = Integer.toBinaryString(x);
        String b = Integer.toBinaryString(y);
        if(a.length()<b.length()){
            for(int i=a.length();i<b.length();i++){
                a = "0"+a;
            }
        }
        else if(a.length()>b.length()){
            for(int i=b.length();i<a.length();i++){
                b = "0"+b;
            }
        }
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int count = 0;
        for(int i=0;i<c1.length;i++){
            if(c1[i]!=c2[i])
                count++;
        }
        System.out.println(a);
        System.out.println(b);
        return count;
    }
}

Hamming distance is the number of bits by which two numbers differ. 
Exor operator gives output 0 if both bits are same and 1 if bits are different.If we Exor first number with second then we will get a number
which will have 1 in places where both the numbers differ from each other.Now count these ones.

class Solution {
    public int hammingDistance(int x, int y) {
        int k = x^y;
        int count = 0;
        while(k!=0){
            System.out.println(k);
            count += k&1;
            System.out.println("Count"+count);
            k = k >> 1;
        }
        return count;
    }
}