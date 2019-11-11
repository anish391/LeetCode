import java.util.LinkedHashSet;

public class Substrings {

    public LinkedHashSet<String> kSubStrings(String s, int k){
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i=0;i<s.length()-k-1;i++){
            String str = "";
            for(int j=i;j<i+k;j++){
                if(str.indexOf(s.charAt(j))!=-1)
                    break;
                str+= s.charAt(j);
            }
            if(str.length()==k)
                set.add(str);
        }
        return set;
    }

    public static void main(String[] args) {
        String s = "awaglknagawunagwkwagl";
        int k = 4;
        Substrings ss = new Substrings();
        System.out.println(ss.kSubStrings(s, k));
        s = "abacab";
        k = 3;
        System.out.println(ss.kSubStrings(s, k));
    }
}
